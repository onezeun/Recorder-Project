package com.record.backend.domain.user;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserForm {

	@NotEmpty(message = "회원 이메일은 필수 입니다.")
	private String email;

	@NotEmpty(message = "회원 비밀번호는 필수 입니다.")
	private String password;

	@NotEmpty(message = "회원 닉네임은 필수 입니다.")
	private String nickname;

	@NotEmpty(message = "블로그 도메인은 필수 입니다.")
	private String domain;
}
