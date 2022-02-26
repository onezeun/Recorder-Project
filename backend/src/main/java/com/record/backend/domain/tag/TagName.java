package com.record.backend.domain.tag;

import java.util.Locale;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import com.record.backend.exception.IllegalUserException;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Embeddable
public class TagName {

	private static final int MAX_LENTH = 20;

	@Column(name = "NAME", nullable = false, unique = true, length = MAX_LENTH)
	private String value;

	private TagName(String value) {
		validateNotNull(value);
		validateNotBlank(value);
		validateLength(value);
		this.value = value.trim().toLowerCase();
	}

	public static TagName of(String value) {
		return new TagName(value);
	}

	private void validateLength(String value) {
		if (Objects.isNull(value)) {
			throw new IllegalUserException("태그 이름이 비어있습니다.");
		}
	}

	private void validateNotBlank(String value) {
		if (value.isBlank()) {
			throw new IllegalUserException("태그에 빈칸이 있습니다.");
		}
	}

	private void validateNotNull(String value) {
		if (value.length() > MAX_LENTH) {
			throw new IllegalUserException("길이가 20을 넘습니다.");
		}
	}

}
