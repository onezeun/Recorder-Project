package com.record.backend.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.record.backend.domain.user.User;
import com.record.backend.repository.UserRepository;


import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

/*
	@Transactional
	public Long save(UserSaveRequestDto requestDto) {
		return userRepository.save(requestDto.toEntity()).getId();
	}
*/

	public Optional<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public Optional<User> findByDomain(String domain) {
		return userRepository.findByDomain(domain);
	}
}
