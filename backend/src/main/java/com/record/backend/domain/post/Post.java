package com.record.backend.domain.post;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.record.backend.domain.BaseEntity;
import com.record.backend.domain.category.Category;
import com.record.backend.domain.user.User;
import com.record.backend.domain.comment.Comment;

import com.record.backend.dto.post.PostUpdateDto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@NoArgsConstructor
public class Post extends BaseEntity {
	private static final int MAX_NAME_LENGTH = 30;
	private static final int MAX_TAG_SIZE = 5;

	@Id
	@GeneratedValue
	@Column(name = "post_id")
	private Long id;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "user_id")
	private User user; //작성자

	private String title; //제목

	@Lob
	private String content; //내용

	private int hits = 0; //조회수

	private String summary;

	@Enumerated(EnumType.STRING)
	private Exposure exposure; // ALL, NEIGHBOR, NO

	private byte[] thumbnail_image;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "category_id")
	private Category category;

	//1대 다 관계
	@OneToMany(mappedBy = "post")
	private List<Comment> comments = new ArrayList<>();
/*
	@OneToMany(mappedBy = "post")
	private List<PostLike> postLikes = new ArrayList<>();
*/
	@Embedded
	private PostLikes postLikes;

	@OneToMany(mappedBy = "post")
	private List<PostTag> postTags = new ArrayList<>();


	@Builder
	public Post(User user, String title,
			  String content, String summary,
			  Category category, Exposure exposure, PostLikes postLikes) {

		this.user = user;
		this.title = title;
		this.content = content;
		this.summary = summary;
		this.category = category;
		this.exposure = exposure;
		this.postLikes = postLikes;
	}

	public void updatePost(PostUpdateDto updateDto) {
		this.title = updateDto.getTitle();
		this.content = updateDto.getContent();
		this.summary = updateDto.getSummary();
		this.exposure = Exposure.valueOf(updateDto.getExposure());
		//		this.thumbnail_image = updateDto.getThumbnail_image();
		//		this.postTagList = updateDto.getPostTagList();
	}

	//==비즈니스 로직==//

	//조회수
	public void addHits() {
		this.hits += 1;
	}

	public void postLike(User user) {
		PostLike postLike = new PostLike(this, user);
		postLikes.add(postLike);
	}

	public void unPostLike(User user) {
		PostLike postLike = new PostLike(this, user);
		postLikes.remove(postLike);
	}

	public int getLikeCounts() {
		return postLikes.getCounts();
	}

	public PostLikes getPostLikes() {
		return postLikes;
	}

	public List<User> getPostLikeUsers() {
		return postLikes.getLikeUsers();
	}
}
