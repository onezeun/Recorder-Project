package com.record.backend.domain.user;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.record.backend.domain.category.Category;
import com.record.backend.domain.comment.Comment;
import com.record.backend.domain.neighbor.Neighbor;
import com.record.backend.domain.post.Post;
import com.record.backend.domain.post.Posts;
import com.record.backend.domain.user.follow.Follow;
import com.record.backend.domain.user.follow.Followers;
import com.record.backend.domain.user.follow.Followings;

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

	@Embedded
	private Followers followers;

	@Embedded
	private Followings followings;

	@Embedded
	private Posts posts;

	//1대 다 관계
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Post> postList = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Category> categoryList = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Comment> commentList = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Neighbor> neighbors = new ArrayList<>();

/*	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<PostLike> postLikeList = new ArrayList<>();*/

	@Builder
	public User (String email, String password, String nickname, String domain, String introduce, Posts posts, Followers followers, Followings followings) {
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.domain = domain;
		this.introduce = introduce;
		this.posts = posts;
		this.followers = followers;
		this.followings = followings;
	}

	//==post 로직==//
	public int getPostCount() {
		return posts.count();
	}


	//==follow 로직==//
	public void follow(User target) {
		Follow follow = new Follow(this, target);
		this.followings.add(follow);
		target.followers.add(follow);
	}

	public void unfollow(User target) {
		Follow follow = new Follow(this, target);
		this.followings.remove(follow);
		target.followings.remove(follow);
	}

	public Boolean isFollowing(User targetUser) {
		if (this.equals(targetUser)) {
			return null;
		}

		return this.followings.isFollowing(targetUser);
	}

	public int getFollowerCount() {
		return followers.count();
	}

	public int getFollowingCount() {
		return followings.count();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof User)) {
			return false;
		}

		User user = (User) o;

		return id != null ? id.equals(user.getId()) : user.getId() == null;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}

}
