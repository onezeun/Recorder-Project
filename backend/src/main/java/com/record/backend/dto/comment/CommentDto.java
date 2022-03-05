package com.record.backend.dto.comment;

import com.record.backend.domain.comment.Comment;

import lombok.Data;

@Data
public class CommentDto {

	private Long commentId;
	private String content;

	public CommentDto(Comment comment) {
		commentId = comment.getId();
		content = comment.getContent().getValue();
	}
}
