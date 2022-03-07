package com.record.backend.domain.comment;

import static javax.persistence.FetchType.*;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.record.backend.domain.BaseEntity;
import com.record.backend.domain.user.User;
import com.record.backend.domain.post.Post;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Comment extends BaseEntity {

	@Id @GeneratedValue
	@Column(name = "comment_id")
	private Long id;

	@Embedded
	private CommentContent content;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "post_id")
	private Post post;
/*
	@Column
	private String content;*/

	protected Comment() {
	}

	public Comment(String content, User user, Post post) {
		this(null, content, user, post);
	}

	@Builder
	public Comment(Long id, String content, User user, Post post) {
		this.id = id;
		this.content = new CommentContent(content);
		this.user = user;
		this.post = post;
	}

	public byte[] getProfilePhothoUrl() {
		return user.getProfile_photo();
	}

	public String getAuthorName() {
		return user.getNickname();
	}



}
