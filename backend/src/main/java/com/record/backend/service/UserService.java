package com.record.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.record.backend.domain.user.User;
import com.record.backend.dto.user.FollowRequestDto;
import com.record.backend.dto.user.FollowResponseDto;
import com.record.backend.dto.user.UserDtoAssembler;
import com.record.backend.dto.user.UserUpdateDto;
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
		validateExistUserEmail(requestDto.getEmail());
		validateExistUserDomain(requestDto.getDomain());
		return userRepository.save(requestDto.toEntity()).getId();
	}


	@Transactional
	public Long updateUser (Long id, UserUpdateDto updateDto) {
		User user = findUser(id);
		user.setNickname(updateDto.getNickname());
		user.setIntroduce(updateDto.getIntroduce());
		user.setPassword(updateDto.getPassword());
		//도메인 검증
		validateExistUserDomain(updateDto.getDomain());
		user.setDomain(updateDto.getDomain());
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

	private void validateExistUserEmail(String email) {
		if (userRepository.findByEmail(email).isPresent()) {
			throw new IllegalUserException("이미 존재하는 이메일입니다.");
		}
	}

	public void validateExistUserDomain(String domain) {
		if (userRepository.findByDomain(domain).isPresent()) {
			throw new IllegalUserException("이미 존재하는 도메인입니다.");
		}
	}

	//==팔로우 로직==//
	@Transactional
	public FollowResponseDto followUser(FollowRequestDto requestDto) {
		UserSaveRequestDto userSaveRequestDto = requestDto.getUserSaveRequestDto();
		User source = findUserByDomin(userSaveRequestDto.getDomain());
		User target = findUserByDomin(requestDto.getTargetName());

		source.follow(target);

		return UserDtoAssembler.followResponseDto(target, true);
	}

	@Transactional
	public FollowResponseDto unfollowUser(FollowRequestDto requestDto) {
		UserSaveRequestDto userSaveRequestDto = requestDto.getUserSaveRequestDto();
		User source = findUserByDomin(userSaveRequestDto.getDomain());
		User target = findUserByDomin(requestDto.getTargetName());

		source.unfollow(target);
		return UserDtoAssembler.followResponseDto(target, false);
	}



	private User findUserByDomin(String domain) {
		return userRepository.findByDomain(domain).get();
	}
}
