package com.record.backend.apiController.login;

import java.net.URI;
import java.util.Collections;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.record.backend.domain.jwt.RefreshToken;
import com.record.backend.domain.user.Role;
import com.record.backend.domain.user.RoleName;
import com.record.backend.domain.user.User;
import com.record.backend.dto.loginlogout.request.LoginRequest;
import com.record.backend.dto.loginlogout.request.SignUpRequest;
import com.record.backend.dto.loginlogout.request.TokenRefreshRequest;
import com.record.backend.dto.loginlogout.response.ApiResponse;
import com.record.backend.dto.loginlogout.response.JwtAuthenticationResponse;
import com.record.backend.dto.loginlogout.response.TokenRefreshResponse;
import com.record.backend.exception.AppException;
import com.record.backend.exception.TokenRefreshException;
import com.record.backend.repository.RoleRepository;
import com.record.backend.repository.UserRepository;
import com.record.backend.security.JwtTokenProvider;
import com.record.backend.security.RefreshTokenService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	RefreshTokenService refreshTokenService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	JwtTokenProvider tokenProvider;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(
				loginRequest.getEmail(),
				loginRequest.getPassword()
			)
		);

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = tokenProvider.generateToken(authentication);

		RefreshToken refreshToken = refreshTokenService.createRefreshToken(authentication);
		return ResponseEntity.ok(new JwtAuthenticationResponse(jwt, refreshToken.getToken()));
	}

	@PostMapping("/refreshtoken")
	public ResponseEntity<?> refreshtoken(@Valid @RequestBody TokenRefreshRequest tokenRefreshRequest) {
		String requestRefreshToken = tokenRefreshRequest.getRefreshToken();

		return refreshTokenService.findByToken(requestRefreshToken)
			.map(refreshTokenService::verifyExpiration)
			.map(RefreshToken::getUser)
			.map(user -> {
				Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
						user.getEmail(), user.getPassword()
					)
				);
				String token = tokenProvider.generateToken(authentication);
				return ResponseEntity.ok(new TokenRefreshResponse(token, requestRefreshToken));

			})
			.orElseThrow(() -> new TokenRefreshException(requestRefreshToken, "Refresh token is not in database!"));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
				HttpStatus.BAD_REQUEST);
		}

		if (userRepository.existsByDomain(signUpRequest.getDomain())) {
			return new ResponseEntity(new ApiResponse(false, "Domain already in use!"),
				HttpStatus.BAD_REQUEST);
		}

		//Creating user's account
		User user = new User(signUpRequest.getEmail(), signUpRequest.getPassword(), signUpRequest.getNickname(),
			signUpRequest.getDomain(), signUpRequest.getIntroduce());

		user.setPassword(passwordEncoder.encode(user.getPassword()));

		Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
			.orElseThrow(() -> new AppException("User Role not set."));

		user.setRoles(Collections.singleton(userRole));

		User result = userRepository.save(user);

		URI location = ServletUriComponentsBuilder
			.fromCurrentContextPath().path("/api/users/{userEmail}")
			.buildAndExpand(result.getEmail()).toUri();

		return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
	}

}
