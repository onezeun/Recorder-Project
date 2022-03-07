package com.record.backend.domain.comment;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.record.backend.exception.IllegalUserException;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Embeddable
public class CommentContent {

	private static final int MAX_LENGTH = 150;

	@Column(name = "NAME", nullable = false, length = MAX_LENGTH)
	private String value;

	public CommentContent(String value) {
		validateNotNull(value);
		validateLength(value);
		this.value = value;
	}

	public static CommentContent of(String value) {
		return new CommentContent(value);
	}

	private void validateNotNull(String value) {
		if (value.length() > MAX_LENGTH) {
			throw new IllegalUserException("댓글 내용이 비어있습니다.");
		}
	}

	private void validateLength(String value) {
		if (Objects.isNull(value)) {
			throw new IllegalUserException("길이가 20을 넘습니다.");
		}
	}
}
