package com.record.backend.dto.user;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FollowRequestDto {

	private UserSaveRequestDto userSaveRequestDto;
	private String targetName;

	public FollowRequestDto(UserSaveRequestDto userSaveRequestDto,
		String targetName) {
		this.userSaveRequestDto = userSaveRequestDto;
		this.targetName = targetName;
	}
}
