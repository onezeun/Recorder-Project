package com.record.backend.repository.dto;

import com.record.backend.domain.comment.Comment;
import com.record.backend.domain.post.Exposure;
import com.record.backend.domain.post.Post;
import com.record.backend.domain.post.PostLike;
import com.record.backend.domain.post.PostTag;
import com.record.backend.domain.user.User;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public class PostResponseDto {

	private Long post_id;
	private Long user_id;
	private String user_nickname;
	private byte[] user_profile_photo;
	private String user_introduce;
	private byte[] thumbnail_image;
	private String title;
	private String content;
	private int hits;
	private Exposure exposure;
	private LocalDateTime created_time;
	private LocalDateTime update_time;
	private List<Comment> commentList;
	private List<PostLike> postLikeList;
	private List<PostTag> postTagList;

	public PostResponseDto(Post entity) {
		this.post_id = entity.getId();
		this.user_id = entity.getUser().getId();
		this.user_nickname = entity.getUser().getNickname();
		this.user_profile_photo = entity.getUser().getProfile_photo();
		this.user_introduce = entity.getUser().getIntroduce();
		this.thumbnail_image = entity.getThumbnail_image();
		this.title = entity.getTitle();
		this.content = entity.getContent();
		this.hits = entity.getHits();
		this.exposure = entity.getExposure();
		this.created_time = entity.getCreated_time();
		this.update_time = entity.getUpdate_time();
		this.commentList = entity.getCommentList();
		this.postLikeList = entity.getPostLikeList();
		this.postTagList = entity.getPostTagList();
	}
}
