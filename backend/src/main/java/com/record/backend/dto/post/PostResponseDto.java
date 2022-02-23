package com.record.backend.dto.post;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.record.backend.domain.comment.Comment;
import com.record.backend.domain.post.Exposure;
import com.record.backend.domain.post.Post;
import com.record.backend.domain.post.PostLike;
import com.record.backend.domain.post.PostTag;
import com.record.backend.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
public class PostResponseDto {

	private Long post_id;
	private Long user_id;
	private String user_nickname;
//	private byte[] user_profile_photo;
//	private String user_introduce;
//	private byte[] thumbnail_image;
	private String title;
	private String content;
	private String summary;
	private int hits;
	private Exposure exposure;

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime created_time;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime update_time;

//	private List<Comment> commentList;
//	private List<PostLike> postLikeList;
//	private List<PostTag> postTagList;

	public PostResponseDto(Post post) {
		this.post_id = post.getId();
		this.user_id = post.getUser().getId();
		this.user_nickname = post.getUser().getNickname();
		this.title = post.getTitle();
		this.content = post.getContent();
		this.summary = post.getSummary();
		this.hits = post.getHits();
		this.exposure = post.getExposure();
	}

}
