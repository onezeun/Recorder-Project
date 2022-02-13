package com.record.backend.domain.post;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.record.backend.domain.category.Category;
import com.record.backend.domain.user.User;
import com.record.backend.domain.comment.Comment;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@NoArgsConstructor
public class Post {

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

	private int hits; //조회수

	private String summary;

	@Enumerated(EnumType.STRING)
	private Exposure exposure; // ALL, NEIGHBOR, NO

	private byte[] thumnail_image;

	private LocalDateTime created_time = LocalDateTime.now();

	private LocalDateTime update_date;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "category_id")
	private Category category;

	//1대 다 관계
	@OneToMany(mappedBy = "post")
	private List<Comment> commentList = new ArrayList<>();

	@OneToMany(mappedBy = "post")
	private List<PostLike> postLikeList = new ArrayList<>();

	@OneToMany(mappedBy = "post")
	private List<PostTag> postTagList = new ArrayList<>();

	@Builder
	public Post(User user, String title, String content,
				String summary, Exposure exposure,
				byte[] thumnail_image, Category category) {
		this.user = user;
		this.title = title;
		this.content = content;
		this.summary = summary;
		this.exposure = exposure;
		this.thumnail_image = thumnail_image;
		this.category = category;

		this.hits = 0;
	}

	//==연관 관계 메서드==//
	public void addComment(Comment comment) {
		this.commentList.add(comment);
		//무한루프에 빠지지 않도록 체크
		if (comment.getPost() != this) {
			comment.setPost(this);
		}
	}

	//==비즈니스 로직==//
	

}
