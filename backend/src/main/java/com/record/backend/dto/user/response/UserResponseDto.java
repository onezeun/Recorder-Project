package com.record.backend.dto.user.response;

import com.record.backend.domain.user.User;

import lombok.Data;

@Data
public class UserResponseDto {


	private Long userId;
	private String email;
	private String nickname;
	private String picture;
	private String domain;
	private String introduce;

	public UserResponseDto(User user) {
		this.userId = user.getId();
		this.email = user.getEmail();
		this.nickname = user.getNickname();
		this.picture = user.getPicture();
		this.domain = user.getDomain();
		this.introduce = user.getIntroduce();
	}
}
