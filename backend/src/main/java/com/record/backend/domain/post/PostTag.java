package com.record.backend.domain.post;

import static javax.persistence.FetchType.*;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.record.backend.domain.tag.Tag;
import com.record.backend.exception.IllegalUserException;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class PostTag {

	@Id @GeneratedValue
	@Column(name = "post_tag_id")
	private Long id;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "post_id")
	private Post post;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "tag_id")
	private Tag tag;

	@Column
	private boolean deleted;

	private PostTag(Post post, Tag tag) {
		validateNotNull(post, tag);
		this.post = post;
		this.tag = tag;
	}

	private void validateNotNull(Post post, Tag tag) {
		if (Objects.isNull(post)) {
			throw new IllegalUserException("PostTag 생성시 Post는 null이 될 수 없습니다.");
		}
		if (Objects.isNull(tag)) {
			throw new IllegalUserException("PostTag 생성시 Tag는 null이 될 수 없습니다.");
		}
	}

	public static PostTag of(Post post, Tag tag) {
		return new PostTag(post, tag);
	}

	public void delete() {
		this.deleted = true;
	}
}
