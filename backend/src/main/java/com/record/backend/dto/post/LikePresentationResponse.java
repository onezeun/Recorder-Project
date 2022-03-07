package com.record.backend.dto.post;

import lombok.Builder;

@Builder
public class LikePresentationResponse {

	private int likesCount;
	private boolean liked;

	private LikePresentationResponse() {

	}

	public LikePresentationResponse(int likesCount, boolean liked) {
		this.likesCount = likesCount;
		this.liked = liked;
	}

	public int getLikesCount() {
		return likesCount;
	}

	public boolean getLiked() {
		return liked;
	}
}
