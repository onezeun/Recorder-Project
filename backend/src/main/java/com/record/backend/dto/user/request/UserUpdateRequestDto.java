package com.record.backend.dto.user.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserUpdateRequestDto {

	@NotEmpty
	private String email;
	@NotEmpty
	private String nickname;
	private String picture;

	@NotEmpty
	private String domain;

	@Size(max = 20)
	private String introduce;
}
