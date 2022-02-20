package com.record.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.record.backend.domain.user.User;
import com.record.backend.exception.IllegalUserException;
import com.record.backend.repository.UserRepository;
import com.record.backend.dto.user.UserResponseDto;
import com.record.backend.dto.user.UserSaveRequestDto;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	@Transactional
	public Long saveUser(UserSaveRequestDto requestDto) {
		return userRepository.save(requestDto.toEntity()).getId();
	}

	public UserResponseDto getUser(Long id) {
		return new UserResponseDto(findUser(id));
	}

	public List<UserResponseDto> getUserList() {
		return userRepository.findAll().stream()
			.map(UserResponseDto::new)
			.collect(Collectors.toList());
	}

	public Long updateUser (Long id, UserResponseDto responseDto) {
		User user = findUser(id);
		user.setNickname(responseDto.getNickname());
		if (validateExistUserDomain(responseDto.getDomain())) {
			throw new IllegalUserException("이미 존재하는 도메인입니다.");
		}
		else {
			user.setDomain(responseDto.getDomain());
		}
		user.setIntroduce(responseDto.getIntroduce());
		return user.getId();
	}

	public Long updateUserPassword(Long id, UserResponseDto responseDto) {
		User user = findUser(id);
		user.setPassword(responseDto.getPassword());
		return user.getId();
	}
/*
	public Long updateUserDomain(Long id, UserResponseDto responseDto) {
		User user = findUser(id);
		if (validateExistUserDomain(responseDto.getDomain())) {
			throw new IllegalUserException("이미 존재하는 도메인입니다.");
		}
		else {
			user.setDomain(responseDto.getDomain());
		}
		return user.getId();
	}*/

	public void deleteUser (Long id) {
		userRepository.delete(findUser(id));
	}

	public User findUser(Long id) {
		return userRepository.findById(id)
			.orElseThrow(() -> new IllegalUserException("찾는 멤버 없습니다."));
	}

	public Optional<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public Optional<User> findByDomain(String domain) {
		return userRepository.findByDomain(domain);
	}

	public boolean validateExistUserDomain(String domain) {
		return userRepository.existsByDomain(domain);
	}
}
