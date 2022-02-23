package com.record.backend.dto.user;

import com.record.backend.domain.user.User;

import lombok.Data;

@Data
public class UserResponseDto {

	private Long userId;
	private String email;
	private String nickname;
	private String domain;
	private String introduce;

	public UserResponseDto(User entity) {
		this.userId = entity.getId();
		this.email = entity.getEmail();
		this.nickname = entity.getNickname();;
		this.domain = entity.getDomain();
		this.introduce = entity.getIntroduce();
	}
}
