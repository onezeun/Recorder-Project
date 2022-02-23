package com.record.backend.dto.user;

import com.record.backend.domain.user.User;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class UserSaveRequestDto {

	private String email;
	private String password;
	private String nickname;
	private String domain;
	private String introduce;

	public User toEntity() {
		return User.builder()
			.email(email)
			.password(password)
			.nickname(nickname)
			.domain(domain)
			.introduce(introduce)
			.build();
	}
}
