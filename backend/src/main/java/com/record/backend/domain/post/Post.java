package com.record.backend.domain.post;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.record.backend.domain.User;
import com.record.backend.domain.comment.Comment;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Post {

	@Id
	@GeneratedValue
	@Column(name = "post_id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	private String content_url;

	private String summary;

	private String exposure;

	private byte[] thumnail_image;

	private LocalDateTime created_time;

	//1대 다 관계
	@OneToMany(mappedBy = "post")
	private List<Comment> commentList = new ArrayList<>();

	@OneToMany(mappedBy = "post")
	private List<PostCategory> postCategoryList = new ArrayList<>();

	@OneToMany(mappedBy = "post")
	private List<PostLike> postLikeList = new ArrayList<>();

	@OneToMany(mappedBy = "post")
	private List<PostTag> postTagList = new ArrayList<>();
}
