package com.record.backend.domain.user;

import static javax.persistence.CascadeType.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.record.backend.domain.alert.Alert;
import com.record.backend.domain.category.Category;
import com.record.backend.domain.comment.Comment;

import com.record.backend.domain.follow.Followers;
import com.record.backend.domain.follow.Followings;
import com.record.backend.domain.post.PostLike;

import lombok.Builder;
import lombok.Getter;

import lombok.Setter;

@Entity
@Getter @Setter
public class User {

	@Id @GeneratedValue
	@Column(name = "user_id")
	private Long id;

	@Column(unique = true)
	private String email;

	private String password;

	private String nickname;

	private String picture;

	private String domain;

	private String introduce;




	@OneToMany(mappedBy = "user", cascade = ALL)
	private List<Category> categoryList = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = ALL)
	private List<Comment> commentList = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = ALL)
	private List<PostLike> postLikeList = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = ALL)
	private List<Followings> followingsList = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = ALL)
	private List<Followers> followersList = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = ALL)
	private List<Alert> alerts = new ArrayList<>();


	@Builder
	public User(String email, String password, String nickname, String picture, String domain,
		String introduce) {
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.picture = picture;
		this.domain = domain;
		this.introduce = introduce;
	}

/*	public String getRoleKey() {
		return this.role.getKey();
	}
*/

}
