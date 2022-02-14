package com.record.backend.repository.dto;

import java.time.LocalDateTime;

import com.record.backend.domain.post.Exposure;
import com.record.backend.domain.post.Post;

import lombok.Data;

@Data
public class PostDto {

	private Long postId;
	private String nickname;
	private String title;
	private String content;
	private int hits;
	private String summary;
	private Exposure exposure;
	private byte[] thumbnail_image;
	private LocalDateTime created_time;
	private LocalDateTime update_time;

	public PostDto(Post post) {
		postId = post.getId();
		nickname = post.getUser().getEmail();
		title = post.getTitle();
		content = post.getContent();
		hits = post.getHits();
		summary = post.getSummary();
		exposure = post.getExposure();
		thumbnail_image = post.getThumbnail_image();
		created_time = post.getCreated_time();
		update_time = post.getUpdate_time();
	}
}
