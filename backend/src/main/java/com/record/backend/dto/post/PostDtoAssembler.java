package com.record.backend.dto.post;

public class PostDtoAssembler {

	public static LikePresentationResponse likePresentationResponse(LikeResponseDto likeResponseDto) {
		return LikePresentationResponse.builder()
			.likesCount(likeResponseDto.getLikesCount())
			.liked(likeResponseDto.getLiked())
			.build();
	}
}
