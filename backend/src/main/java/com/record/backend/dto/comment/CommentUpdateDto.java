package com.record.backend.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentUpdateDto {

	private Long commentId;
	private Long postId;
	private Long userId;
	private String content;
}
