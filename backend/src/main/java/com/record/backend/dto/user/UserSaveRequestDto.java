package com.record.backend.dto.user;

import com.record.backend.domain.user.User;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class UserSaveRequestDto {

	private Long userId;
	private String email;
	private String password;
	private String nickname;
	private String domain;
	private String introduce;

	@Builder
	public UserSaveRequestDto(String email, String password, String nickname, String domain,
		String introduce) {
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.domain = domain;
		this.introduce = introduce;
	}

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
