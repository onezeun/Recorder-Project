package com.record.backend.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.record.backend.domain.comment.Comment;
import com.record.backend.domain.comment.CommentLike;
import com.record.backend.domain.post.Post;
import com.record.backend.domain.post.PostCategory;
import com.record.backend.domain.post.PostLike;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class User {

	@Id @GeneratedValue
	@Column(name = "user_id")
	private Long id;

	private String email;

	private String password;

	private String name;

	private String nickname;

	private String domain;

	private byte[] profile_photo;

	private String introduce;

	private LocalDateTime created_time;

	@OneToMany(mappedBy = "user") //1대 다 관계 category table에 있는 user에 의해서 매핑된 거울일 뿐이야.. 읽기전용이란 뜻
	private List<Category> categories = new ArrayList<>();

	@OneToMany(mappedBy = "alert")
	private Alert alert;

	@OneToMany(mappedBy = "comment")
	private Comment comment;

	@OneToMany(mappedBy = "post")
	private Post post;

	//다대다 관계 풀어낸 1대 다 관계 아래로
	@OneToMany(mappedBy = "user_id")
	private List<CommentLike> commentLikeList = new ArrayList<>();

	@OneToMany(mappedBy = "user_id")
	private List<PostCategory> postCategoryList = new ArrayList<>();

	@OneToMany(mappedBy = "user_id")
	private List<PostLike> postLikeList = new ArrayList<>();

}
