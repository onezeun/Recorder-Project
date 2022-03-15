package com.record.backend.service;

import org.springframework.stereotype.Service;

import com.record.backend.domain.user.User;
import com.record.backend.dto.user.LoginDto;
import com.record.backend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LoginService {

	private final UserRepository userRepository;

	/**
	 * null이면 로그인 실패
	 */
	public User login(LoginDto loginDto) {
		return userRepository.findByEmail(loginDto.getLoginId())
			.filter(u -> u.getPassword().equals(loginDto.getPassword()))
			.orElse(null); //비번이 안맞음
	}
}
