package com.record.backend.dto.comment.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.record.backend.domain.comment.Comment;
import com.record.backend.domain.post.Post;
import com.record.backend.domain.user.User;

import lombok.Data;

@Data
public class CommentSaveRequestDto {

	private Long userId;
	private Long postId;
	private Long commentId;

	private User user;
	private Post post;

	@NotEmpty
	@Size(min = 1, max = 150)
	private String content;

	public Comment toEntity() {
		return Comment.builder()
			.content(this.content)
			.user(this.user)
			.post(this.post)
			.build();
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setPost(Post post) {
		this.post = post;
	}
}
