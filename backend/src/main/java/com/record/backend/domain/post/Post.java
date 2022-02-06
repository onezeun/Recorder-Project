package com.record.backend.domain.post;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.record.backend.domain.User;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Post {

	@Id @GeneratedValue
	@Column(name = "post_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	private String Content_url;

	private String summary;

	private String exposure;

	private byte[] thumnail_url;

	private LocalDateTime created_time;


	@OneToMany(mappedBy = "post_id")
	private List<PostCategory> postCategoryList = new ArrayList<>();

	@OneToMany(mappedBy = "post_id")
	private List<PostLike> postLikesList = new ArrayList<>();

	@OneToMany(mappedBy = "post_id")
	private List<PostTag> postTagList = new ArrayList<>();


}
