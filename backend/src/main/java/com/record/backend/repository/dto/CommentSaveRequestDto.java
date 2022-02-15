package com.record.backend.repository.dto;

import com.record.backend.domain.comment.Comment;
import com.record.backend.domain.post.Post;
import com.record.backend.domain.user.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class CommentSaveRequestDto {

	private User user;
	private Post post;
	private String content;

	@Builder
	public CommentSaveRequestDto(User user, Post post, String content) {
		this.user = user;
		this.post = post;
		this.content = content;
	}

	public Comment toEntity() {
		return Comment.builder()
			.content(content)
			.build();
	}
}
