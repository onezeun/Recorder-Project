package com.record.backend.domain.tag;

import static javax.persistence.FetchType.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.record.backend.domain.BaseEntity;
import com.record.backend.domain.post.PostTag;
import com.record.backend.exception.IllegalUserException;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Tag extends BaseEntity {

	@Id
	@GeneratedValue
	@Column(name = "tag_id")
	private Long id;

	@Embedded
	private TagName tagName;

	@OneToMany(mappedBy = "tag")
	private List<PostTag> postTagList = new ArrayList<>();

	public Tag(TagName tagName) {
		validateNotNull(tagName);
		this.tagName = tagName;
	}

	public static Tag of(TagName tagName) {
		return new Tag(tagName);
	}

	public static Tag of(String tagNameValue) {
		return new Tag(TagName.of(tagNameValue));
	}

	private void validateNotNull(TagName tagName) {
		if (Objects.isNull(tagName)) {
			throw new IllegalUserException("태그 이름이 비어있습니다.");
		}
	}

	public String getTagNameValue() {
		return tagName.getValue();
	}
}
