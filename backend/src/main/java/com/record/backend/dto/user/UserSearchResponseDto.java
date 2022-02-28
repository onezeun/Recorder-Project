package com.record.backend.dto.user;

import lombok.Builder;

@Builder
public class UserSearchResponseDto {
	private String domain;
	private boolean following;

	private UserSearchResponseDto() {

	}

	public UserSearchResponseDto(String domain, boolean following) {
		this.domain = domain;
		this.following = following;
	}

	public String getDomain() {
		return domain;
	}

	public boolean isFollowing() {
		return following;
	}
}
