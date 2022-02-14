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

	@Builder
	public PostSaveRequestDto(User user, String title, String content, int hits, String summary,
		String exposure) {
		this.user = user;
		this.title = title;
		this.content = content;
		this.hits = hits;
		this.summary = summary;
		this.exposure = exposure;
	}

	public Post toEntity() {
		return Post.builder()
			.user(user)
			.title(title)
			.content(content)
			.summary(summary)
			.exposure(exposure)
			.build();
	}
}
