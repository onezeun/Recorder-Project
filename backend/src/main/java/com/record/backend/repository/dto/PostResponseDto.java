package com.record.backend.repository.dto;

import com.record.backend.domain.post.Post;
import com.record.backend.domain.user.User;

import lombok.Getter;

@Getter
public class PostResponseDto {

	private User user;
	private String title;
	private String content;
	private int hits;
	private String summary;
	private String exposure;
	private String content_url;

	public PostResponseDto(Post entity) {
		this.user = entity.getUser();
		this.title = entity.getTitle();
		this.content = entity.getContent();
		this.hits = entity.getHits();
		this.summary = entity.getSummary();
		this.exposure = entity.getExposure();
		this.content_url = entity.getContent_url();
	}
}
