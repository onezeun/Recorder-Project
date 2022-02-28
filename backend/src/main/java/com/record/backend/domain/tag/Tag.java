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
public class Tag extends BaseEntity {

	private static final int MAX_TAG_LENGTH = 20;

	@Id
	@GeneratedValue
	@Column(name = "tag_id")
	private Long id;

	@Column
	private String tagName;

/*	@OneToMany(mappedBy = "tag")
	private List<PostTag> postTagList = new ArrayList<>();*/

}
