package com.record.backend.dto.post.response;

import com.record.backend.domain.post.Exposure;
import com.record.backend.domain.post.Post;

import lombok.Data;

@Data
public class PostAllUsersResponseDto {
	private Long postId;
	private Long userId;
	private Long categoryId;
	private String title;
	private String content;
	private String summary;
	private int hits;
	private Exposure exposure;
	private String thumbnailImage;

	public PostAllUsersResponseDto(Post post) {
		this.postId = post.getId();
		this.userId = post.getUser().getId();
		this.categoryId = post.getCategory().getId();
		this.title = post.getTitle();
		this.content = post.getContent();
		this.summary = post.getSummary();
		this.hits = post.getHits();
		this.exposure = post.getExposure();
		this.thumbnailImage = post.getThumbnail_image();
	}
}
