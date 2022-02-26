package com.record.backend.dto.comment;

import com.record.backend.domain.comment.Comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class CommentResponseDto {
	private Long commentId;
	private Long postId;
	private Long userId;
	private String content;

	public CommentResponseDto(Comment entity) {
		this.commentId = entity.getId();
		this.postId = entity.getPost().getId();
		this.userId = entity.getUser().getId();
		this.content = entity.getContent();
	}

}
