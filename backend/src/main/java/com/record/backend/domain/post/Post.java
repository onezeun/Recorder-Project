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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.record.backend.domain.user.User;
import com.record.backend.domain.comment.Comment;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
public class Post {

	@Id
	@GeneratedValue
	@Column(name = "post_id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user; //작성자

	private String content_url; //url

	private String title; //제목

	@Lob
	private String content; //내용

	private int hits; //조회수

	private String summary;

	private String exposure;

	private byte[] thumnail_image;

	private LocalDateTime created_time = LocalDateTime.now();

	private LocalDateTime update_date;

	//1대 다 관계
	@OneToMany(mappedBy = "post")
	private List<Comment> commentList = new ArrayList<>();

	@OneToMany(mappedBy = "post")
	private List<PostCategory> postCategoryList = new ArrayList<>();

	@OneToMany(mappedBy = "post")
	private List<PostLike> postLikeList = new ArrayList<>();

	@OneToMany(mappedBy = "post")
	private List<PostTag> postTagList = new ArrayList<>();

	@Builder
	public Post(String title, String content, int hits, User user,
		String content_url, String summary, String exposure) {
		this.title = title;
		this.content = content;
		this.hits = hits;
		this.user = user;
		this.content_url = content_url;
		this.summary = summary;
		this.exposure = exposure;
	}
}
