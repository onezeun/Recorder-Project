package com.record.backend.apiController;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.record.backend.domain.user.User;
import com.record.backend.dto.user.UserUpdateDto;
import com.record.backend.dto.user.UserResponseDto;
import com.record.backend.dto.user.UserSaveRequestDto;
import com.record.backend.repository.user.UserRepository;
import com.record.backend.service.UserService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserApiController {

	private final UserService userService;
	private final UserRepository userRepository;

	@PostMapping("/users/account/signup")
	public Long saveUser(@RequestBody UserSaveRequestDto requestDto) {
		return userService.saveUser(requestDto);
	}

	@GetMapping("/users")
	public Result findAllUsers() {
		List<User> allUser = userRepository.findAll();
		List<UserResponseDto> collect = allUser.stream()
			.map(UserResponseDto::new)
			.collect(Collectors.toList());

		return new Result(collect);
	}

	@GetMapping("/users/{user_id}")
	public UserResponseDto findUser (@PathVariable("user_id") Long userId) {
		User findUser = userRepository.findById(userId).get();
		return new UserResponseDto(findUser);
	}


	@PutMapping("/users/{user_id}")
	public Long updateUser(@PathVariable("user_id") Long userId, UserUpdateDto updateDto) {
		return userService.updateUser(userId, updateDto);
	}

	@DeleteMapping("/users/{user_id}")
	public void deleteUser(@PathVariable("user_id") Long userId) {
		userService.deleteUser(userId);
	}

	@Data
	@AllArgsConstructor
	static class Result<T> {
		private T data;
	}

}
