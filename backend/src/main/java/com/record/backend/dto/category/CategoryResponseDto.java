package com.record.backend.dto.category;

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

	private Long categoryId;
	private Long userId;
	private String categoryName;
	private List<Post> postList;

	public CategoryResponseDto(Category entity) {
		this.categoryId = entity.getId();
//		this.user_id = entity.getUser().getId();
		this.categoryName = entity.getName();
		this.postList = entity.getPostList();
	}
}
