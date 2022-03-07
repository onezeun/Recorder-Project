package com.record.backend.dto.user;

import com.record.backend.domain.user.User;

public class UserDtoAssembler {

	public static FollowResponseDto followResponseDto(User target, boolean isFollowing) {
		return FollowResponseDto.builder()
			.followerCount(target.getFollowerCount())
			.isFollowing(isFollowing)
			.build();
	}

	public static FollowRequestDto followRequestDto(String domain) {
		return FollowRequestDto.builder()
			.targetName(domain)
			.build();
	}

	public static FollowPresentationResponse followPresentationResponse(FollowResponseDto followResponseDto) {
		return FollowPresentationResponse.builder()
			.followerCount(followResponseDto.getFollowerCount())
			.following(followResponseDto.isFollowing())
			.build();
	}

	public static FollowSearchRequestDto followSearchRequestDto(
		String domain, Long page, Long limit
	) {
		return FollowSearchRequestDto.builder()
			.domain(domain)
			.page(page)
			.limit(limit)
			.build();
	}
}
