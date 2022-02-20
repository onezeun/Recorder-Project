package com.record.backend.dto.comment;

import com.record.backend.domain.comment.Comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class CommentResponseDto {
	private Long comment_id;
	private Long post_id;
	private Long user_id;
	private String content;

	public CommentResponseDto(Comment entity) {
		this.comment_id = entity.getId();
		this.post_id = entity.getPost().getId();
		this.user_id = entity.getUser().getId();
		this.content = entity.getContent();
	}

}
