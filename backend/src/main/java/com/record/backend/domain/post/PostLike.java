package com.record.backend.domain.post;

import static javax.persistence.FetchType.*;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.relational.core.sql.Like;

import com.record.backend.domain.user.User;
import com.record.backend.exception.IllegalUserException;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class PostLike {

	@Id @GeneratedValue
	@Column(name = "post_like_id")
	private Long id;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "post_id", nullable = false)
	private Post post;

	@Column(nullable = false)
	private Long userId;

/*	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "user_id")
	private User user;*/

	@Builder
	public PostLike(Long id, Post post, Long userId) {
		validateNotNull(post, userId);
		this.id = id;
		this.post = post;
		this.userId = userId;
	}

	private void validateNotNull(Post post, Long userId) {
		if (Objects.isNull(post)) {
			throw new IllegalUserException("포스트 필요");
		}
		if (Objects.isNull(userId)) {
			throw new IllegalUserException("유저 아이디 필요");
		}
	}

	public boolean ownedBy(Long userId) {
		return this.userId.equals(userId);
	}
}
