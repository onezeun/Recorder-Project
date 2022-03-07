package com.record.backend.domain.post;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.springframework.data.relational.core.sql.Like;

import com.record.backend.domain.user.User;
import com.record.backend.exception.IllegalUserException;

public class PostLikes {

	@OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<PostLike> postLikes;

	public PostLikes() {
		this(new ArrayList<>());
	}

	public PostLikes(List<PostLike> postLikes) {
		this.postLikes = postLikes;
	}

	public int getCounts() {
		return postLikes.size();
	}

	public void add(PostLike postLike) {
		if (postLikes.contains(postLike)) {
			throw new IllegalUserException("DuplicatedLikeException");
		}
		postLikes.add(postLike);
	}

	public void remove(PostLike postLike) {
		if (!postLikes.contains(postLike)) {
			throw new IllegalUserException("CannotUnlikeException");
		}
		postLikes.remove(postLike);
	}

	public List<User> getLikeUsers() {
		return postLikes.stream()
			.map(PostLike::getUser)
			.collect(toList());
	}

	public List<PostLike> getLikes() {
		return postLikes;
	}
}
