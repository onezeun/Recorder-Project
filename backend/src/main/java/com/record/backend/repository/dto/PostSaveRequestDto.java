package com.record.backend.repository.dto;

import com.record.backend.domain.post.Post;
import com.record.backend.domain.user.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PostSaveRequestDto {

	private User user;
	private String title;
	private String content;
	private int hits;
	private String summary;
	private String exposure;
	private String content_url;

	@Builder
	public PostSaveRequestDto(String title, String content, int hits, String summary,
		String exposure, String content_url) {
		//this.user = user;
		this.title = title;
		this.content = content;
		this.hits = hits;
		this.summary = summary;
		this.exposure = exposure;
		this.content_url = content_url;
	}

	public Post toEntity() {
		return Post.builder()
			//.user(user)
			.title(title)
			.content(content)
			.hits(hits)
			.summary(summary)
			.exposure(exposure)
			.content_url(content_url)
			.build();
	}
}
