package com.record.backend.apiController;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.record.backend.repository.dto.UserResponseDto;
import com.record.backend.repository.dto.UserSaveRequestDto;
import com.record.backend.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserApiController {

	private final UserService userService;

	@PostMapping("/users/account/signup")
	public Long saveUser(UserSaveRequestDto requestDto) {
		return userService.saveUser(requestDto);
	}

	@GetMapping("/users/{user_id}")
	public UserResponseDto getUser (@PathVariable Long id) {
		UserResponseDto responseDto = userService.getUser(id);
		return responseDto;
	}

	@GetMapping("/users")
	public List<UserResponseDto> getUserList() {
		return userService.getUserList();
	}

	@PutMapping("/users/{user_id}")
	public Long updateUser(@PathVariable Long id, UserResponseDto responseDto) {
		return userService.updateUser(id, responseDto);
	}

	@DeleteMapping("/users/{user_id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
}
