package com.record.backend.dto.post;

import com.record.backend.domain.post.Exposure;
import com.record.backend.domain.post.Post;

import lombok.Data;
//조회 Dto

@Data
public class PostDto {

	private Long postId;
	private String title;
	private String content;
	private String summary;
	private int hits;
	private Exposure exposure;
	private String thumbnailImage;

	public PostDto(Post post) {
		this.postId = post.getId();
		this.title = post.getTitle();
		this.content = post.getContent();
		this.summary = post.getSummary();
		this.hits = post.getHits();
		this.exposure = post.getExposure();
		this.thumbnailImage = post.getThumbnail_image();
	}
}
