package com.record.backend.domain.comment;

import static javax.persistence.FetchType.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.record.backend.domain.post.Post;
import com.record.backend.domain.User;

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

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "parent_comment")
	private Comment parent;

	@OneToMany(mappedBy = "parent")
	private List<Comment> child = new ArrayList<>();

	private LocalDateTime create_time;

	@OneToMany(mappedBy = "comment_id")
	private List<CommentLike> commentLikeList = new ArrayList<>();

	//==연관관계 편이 메서드==//
	public void addChildComment(Comment child) {
		this.child.add(child);
		child.setParent(this);
	}
}
