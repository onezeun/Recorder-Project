package com.record.backend.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserProfile {

	private Long id;
	private String email;
	private String nickname;
	private String domain;
	private String introduce;

	public UserProfile(Long id, String email, String nickname, String domain, String introduce) {
		this.id = id;
		this.email = email;
		this.nickname = nickname;
		this.domain = domain;
		this.introduce = introduce;
	}
}
