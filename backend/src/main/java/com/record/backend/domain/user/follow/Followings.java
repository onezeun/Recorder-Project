package com.record.backend.domain.user.follow;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.record.backend.domain.user.User;
import com.record.backend.exception.IllegalUserException;

@Embeddable
public class Followings {

	@OneToMany(
		mappedBy = "source",
		fetch = FetchType.LAZY,
		cascade = CascadeType.PERSIST,
		orphanRemoval = true
	)
	private List<Follow> followings;

	protected Followings() {
	}

	public Followings(List<Follow> followings) {
		this.followings = followings;
	}

	public void add(Follow follow) {
		if (this.followings.contains(follow)) {
			throw new IllegalUserException("DuplicateFollowException");
		}
		followings.add(follow);
	}

	public void remove(Follow follow) {
		if (!this.followings.contains(follow)) {
			throw new IllegalUserException("InvalidFollowException");
		}
		followings.remove(follow);
	}

	public Boolean isFollowing(User targetUser) {
		return followings.stream()
			.anyMatch(follow -> follow.isFollowing(targetUser));
	}

	public boolean contains(Follow follow) {
		return this.followings.contains(follow);
	}

	public int count() {
		return followings.size();
	}
}
