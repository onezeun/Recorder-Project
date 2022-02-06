package com.record.backend.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.record.backend.domain.comment.CommentLike;
import com.record.backend.domain.post.PostTag;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Tag {

	@Id @GeneratedValue
	@Column(name = "tag_id")
	private Long id;

	private String tag_name;

	@OneToMany(mappedBy = "tag_id")
	private List<PostTag> postTagList = new ArrayList<>();
}
