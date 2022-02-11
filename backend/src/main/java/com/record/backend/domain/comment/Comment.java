package com.record.backend.domain.comment;

import static javax.persistence.FetchType.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.record.backend.domain.user.User;
import com.record.backend.domain.post.Post;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Comment {

	@Id @GeneratedValue
	@Column(name = "comment_id")
	private Long id;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "post_id")
	private Post post;

	@Column(nullable = false, length = 200)
	private String content;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "parent_id")
	private Comment parent;

	@OneToMany(mappedBy = "parent") //self 연관관계
	private List<Comment> child = new ArrayList<>();

	private LocalDateTime created_time;

	//1대 다 관계
	@OneToMany(mappedBy = "comment")
	private List<CommentLike> commentLikeList = new ArrayList<>();

	//==연관관계 편이 메서드==// parent니까 셀프
	public void addChildCategory(Comment child) {
		this.child.add(child);
		child.setParent(this);
	}

	public void setPost(Post post) {
		this.post = post;
		//무한루프에 빠지지 않도록 체크
		if (!post.getCommentList().contains(this)) {
			post.getCommentList().add(this);
		}
	}
}
