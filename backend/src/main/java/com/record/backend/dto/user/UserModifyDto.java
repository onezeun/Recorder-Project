package com.record.backend.dto.user;


import lombok.Data;

@Data
public class UserModifyDto {

	private Long userId;
	private String password;
	private String nickname;
	private String domain;
	private String introduce;
	private byte[] profile_photo;

	public UserModifyDto(Long userId, String nickname, String introduce, byte[] profile_photo) {
		this.userId = userId;
		this.nickname = nickname;
		this.introduce = introduce;
		this.profile_photo = profile_photo;
	}
}
