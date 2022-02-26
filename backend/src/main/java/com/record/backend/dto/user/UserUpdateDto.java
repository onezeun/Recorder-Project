package com.record.backend.dto.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDto {

	private Long userId;
	private String password;
	private String nickname;
	private String domain;
	private String introduce;
	private byte[] profile_photo;

	public UserUpdateDto(Long userId, String nickname, String introduce, byte[] profile_photo) {
		this.userId = userId;
		this.nickname = nickname;
		this.introduce = introduce;
		this.profile_photo = profile_photo;
	}
}
