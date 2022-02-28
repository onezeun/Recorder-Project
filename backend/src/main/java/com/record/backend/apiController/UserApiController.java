package com.record.backend.apiController;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import com.record.backend.dto.user.UserResponseDto;
import com.record.backend.dto.user.UserSaveRequestDto;
import com.record.backend.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserApiController {

	private final UserService userService;

	@PostMapping("/users/account/signup")
	public Long saveUser(@RequestBody UserSaveRequestDto requestDto) {
		return userService.saveUser(requestDto);
	}

	@GetMapping("/users/{user_email}")
	public UserResponseDto getUser (@PathVariable("user_email") String email) {
		UserResponseDto responseDto = userService.getUser(email);
		return responseDto;
	}

	@GetMapping("/users")
	public Result getUserList() {
		List<UserResponseDto> userList = userService.getUserList();
		return new Result(userList);
	}

//	@PutMapping("/users/{user_email}")
//	public Long updateUser(@PathVariable("user_email") Long id, UserResponseDto responseDto) {
//		return userService.updateUser(id, responseDto);
//	}

	@DeleteMapping("/users/{user_email}")
	public void deleteUser(@PathVariable("user_email") Long id) {
		userService.deleteUser(id);
	}

	@Data
	@AllArgsConstructor
	static class Result<T> {
		private T data;
	}
}
