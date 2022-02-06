package com.record.backend.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Category {

	@Id @GeneratedValue
	@Column(name = "category_id")
	private Long id;

	//user category 다대일
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	private String name;

	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Category parent;

	@OneToMany(mappedBy = "parent") //셀프의 연관관계를 건거라고 생각하면 된다.
	private List<Category> child = new ArrayList<>();
}
