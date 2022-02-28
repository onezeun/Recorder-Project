package com.record.backend.domain.user.follow;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.record.backend.domain.user.User;
import com.record.backend.exception.IllegalUserException;

import lombok.Getter;

@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"source_id", "target_id"})
	}
)

@Getter
@Entity
public class Follow {

	@Id @GeneratedValue
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "source_id")
	private User source;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "target_id")
	private User target;

	protected Follow() {
	}
	public Follow(User source, User target) {
		validateDifferentSourceTarget(source, target);
		this.source = source;
		this.target = target;
	}

	private void validateDifferentSourceTarget(User source, User target) {
		if (source.equals(target)) {
			throw new IllegalUserException("Same Source Target User Exception");
		}
	}

	public boolean isFollowing(User targetUser) {
		return this.target.equals(targetUser);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Follow follow = (Follow) o;
		return Objects.equals(getSource(), follow.getSource())
			&& Objects.equals(getTarget(), follow.getTarget());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getSource(), getTarget());
	}

}
