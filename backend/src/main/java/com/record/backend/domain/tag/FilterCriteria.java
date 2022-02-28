package com.record.backend.domain.tag;

import java.util.Locale;
import java.util.Objects;

import com.record.backend.exception.IllegalUserException;

import lombok.Getter;

@Getter
public class FilterCriteria {

	private static final int MAX_NAME_LENGTH = 30;
	private static final String EMPTY = "";

	private final String post;

	public FilterCriteria(String post) {
		this.post = validateName(post);
	}

	private String validateName(String post) {
		if (Objects.isNull(post) || post.isEmpty()) {
			return EMPTY;
		}
		if (post.length() > MAX_NAME_LENGTH) {
			throw new IllegalUserException();
		}
		return post.toLowerCase();
	}

	public boolean isEmpty() {
		return post.isEmpty();
	}
}
