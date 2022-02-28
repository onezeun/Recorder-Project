package com.record.backend.domain.comment;

import static javax.persistence.FetchType.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.record.backend.domain.BaseEntity;
import com.record.backend.domain.tag.TagName;
import com.record.backend.domain.user.User;
import com.record.backend.domain.post.Post;
import com.record.backend.exception.IllegalUserException;

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


	@Builder
	public Comment(String content, Post post, User user) {
		this.content = content;
		this.post = post;
		this.user = user;
	}

}
