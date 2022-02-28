package com.record.backend.dto.user;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FollowPresentationResponse {

	private int followerCount;
	private boolean following;

	private FollowPresentationResponse() {

	}

	public FollowPresentationResponse(int followerCount, boolean following) {
		this.followerCount = followerCount;
		this.following = following;
	}
}
