package com.record.backend.domain.comment;

import static javax.persistence.FetchType.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.record.backend.domain.User;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class CommentLike {

	@Id @GeneratedValue
	@Column(name = "comment_like_id")
	private Long id;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "comment_id")
	private Comment comment;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "user_id")
	private User user;
}
