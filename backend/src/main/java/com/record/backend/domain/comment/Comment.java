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

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "post_id")
	private Post post;

	@Column
	private String content;

	protected Comment() {
	}

	public Comment(User user, Post post) {
		this(null, user, post);
	}

	@Builder
	public Comment(Long id, User user, Post post) {
		this.id = id;
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
