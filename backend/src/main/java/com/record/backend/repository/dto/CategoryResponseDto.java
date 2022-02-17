package com.record.backend.repository.dto;

import java.util.List;

import com.record.backend.domain.category.Category;
import com.record.backend.domain.post.Post;
import com.record.backend.domain.user.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class CategoryResponseDto {

	private Long category_id;
	private Long user_id;
	private String category_name;
	private List<Post> postList;

	public CategoryResponseDto(Category entity) {
		this.category_id = entity.getId();
//		this.user_id = entity.getUser().getId();
		this.category_name = entity.getName();
		this.postList = entity.getPostList();
	}
}
