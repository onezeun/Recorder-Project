package com.record.backend.domain.post;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.record.backend.domain.Tag;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class PostTag {

	@Id @GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post post;

	@ManyToOne
	@JoinColumn(name = "tag_id")
	private Tag tag;
}
