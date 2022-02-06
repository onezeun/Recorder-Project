package com.record.backend.domain.post;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.record.backend.domain.Category;
import com.record.backend.domain.User;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class PostCategory {

	@Id @GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
}
