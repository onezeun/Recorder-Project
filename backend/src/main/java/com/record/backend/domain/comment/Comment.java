package com.record.backend.domain.comment;

import static javax.persistence.FetchType.*;

import javax.persistence.Column;
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

	@Id
	@GeneratedValue
	@Column(name = "comment_id")
	private Long id;

	private String content;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "post_id")
	private Post post;

	@Builder
	public Comment(String content, User user, Post post) {
		this.content = content;
		this.user = user;
		this.post = post;
	}

	public String getProfilePhoto() {
		return user.getPicture();
	}

	public String getAuthorName() {
		return user.getNickname();
	}

}
