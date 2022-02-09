package com.record.backend.domain.category;

import static javax.persistence.FetchType.*;

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
import com.record.backend.domain.post.PostCategory;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Category {

	@Id
	@GeneratedValue
	@Column(name = "category_id")
	private Long id;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	private String name;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "parent_id")
	private Category parent;

	@OneToMany(mappedBy = "parent") //self 연관관계
	private List<Category> child = new ArrayList<>();

	//==연관관계 편이 메서드==// parent니까 셀프
	public void addChildCategory(Category child) {
		this.child.add(child);
		child.setParent(this);
	}

	//1대 다 관계
	@OneToMany(mappedBy = "category")
	private List<PostCategory> postCategoryList = new ArrayList<>();
}
