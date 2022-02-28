package com.record.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.record.backend.domain.user.User;
import com.record.backend.dto.user.UserModifyDto;
import com.record.backend.exception.IllegalUserException;
import com.record.backend.repository.user.UserRepository;
import com.record.backend.dto.user.UserSaveRequestDto;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	//유저 생성
	@Transactional
	public Long saveUser(UserSaveRequestDto requestDto) {
		return userRepository.save(requestDto.toEntity()).getId();
	}

	@Transactional
	public Long updateUser (Long id, UserModifyDto modifyDto) {
		User user = findUser(id);
		user.setNickname(modifyDto.getNickname());
		user.setIntroduce(modifyDto.getIntroduce());
		user.setPassword(modifyDto.getPassword());
		//도메인 검증
		if (validateExistUserDomain(modifyDto.getDomain())) {
			user.setDomain(modifyDto.getDomain());
		}
		return user.getId();
	}

	@Transactional
	public void deleteUser (Long id) {
		userRepository.delete(findUser(id));
	}

	public User findUser(Long id) {
		return userRepository.findById(id)
			.orElseThrow(() -> new IllegalUserException("찾는 멤버 없습니다."));
	}


	public boolean validateExistUserDomain(String domain) {
		if (userRepository.findByDomain(domain).isPresent()) {
			throw new IllegalUserException("이미 존재하는 도메인입니다.");
		} else {
			return true;
		}
	}
}
