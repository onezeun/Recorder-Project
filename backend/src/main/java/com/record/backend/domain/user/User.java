package com.record.backend.domain.user;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.record.backend.domain.category.Category;
import com.record.backend.domain.comment.Comment;
import com.record.backend.domain.comment.CommentLike;
import com.record.backend.domain.post.Post;
import com.record.backend.domain.post.PostLike;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class User {

	@Id @GeneratedValue
	@Column(name = "user_id")
	private Long id;

	@Column(unique = true)
	private String email;

	private String password;

	private String nickname;

	private String domain;

	private byte[] profile_photo;

	private String introduce;

	private LocalDateTime created_time = LocalDateTime.now();

	//1대 다 관계
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Post> postList = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Category> categoryList = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Comment> commentList = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<CommentLike> commentLikeList = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<PostLike> postLikeList = new ArrayList<>();

	@Builder
	public User (String email, String password, String nickname, String domain, String introduce) {
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.domain = domain;
		this.introduce = introduce;
	}
}
