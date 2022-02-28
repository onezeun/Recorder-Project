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
import com.record.backend.domain.tag.Tags;
import com.record.backend.domain.user.User;
import com.record.backend.domain.comment.Comment;

import com.record.backend.dto.post.PostUpdateDto;
import com.record.backend.exception.IllegalUserException;

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

	@OneToMany(mappedBy = "post")
	private List<PostLike> postLikes = new ArrayList<>();

	@OneToMany(mappedBy = "post")
	private List<PostTag> postTags = new ArrayList<>();


	@Builder
	public Post(User user, String title,
			  String content, String summary,
			  Category category, Exposure exposure) {

		this.user = user;
		this.title = title;
		this.content = content;
		this.summary = summary;
		this.category = category;
		this.exposure = exposure;
	}

	//==연관 관계 메서드==//
//	public void addComment(Comment comment) {
//		this.commentList.add(comment);
//		//무한루프에 빠지지 않도록 체크
//		if (comment.getPost() != this) {
//			comment.setPost(this);
//		}
//	}
//
//	public void addPostLike(PostLike postLike) {
//		this.postLikeList.add(postLike);
//		if (postLike.getPost() != this) {
//			postLike.setPost(this);
//		}
//	}
//
//	public void addPostTag(PostTag postTag) {
//		this.postTagList.add(postTag);
//		if (postTag.getPost() != this) {
//			postTag.setPost(this);
//		}
//	}

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

	/**
	 * 태그 생성
	 * @param tags
	 */
	public void setTags(Tags tags) {
		validateTagSize(tags);
		this.postTags.addAll(
			castPostTags(tags)
		);
	}
	private void validateTagSize(Tags tags) {
		Tags currentTags = tags();
		final int alreadyHasTagsSize = currentTags.countSameTagName(tags);
		final int notHasTagsCount = tags.size() - alreadyHasTagsSize;

		if (currentTags.size() + notHasTagsCount > MAX_TAG_SIZE) {
			throw new IllegalUserException();
		}
	}

	private List<PostTag> castPostTags(Tags tags) {
		return tags.stream()
			.map(tag -> PostTag.of(this, tag))
			.collect(Collectors.toList());
	}

	private Tags tags() {
		return Tags.of(postTags.stream()
			.map(PostTag::getTag)
			.collect(Collectors.toList()));
	}

	public void clearPostTags() {
		this.postTags.clear();
	}


}
