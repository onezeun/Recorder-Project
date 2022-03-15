package com.record.backend.dto.category.response;

import java.util.List;
import java.util.stream.Collectors;

import com.record.backend.domain.category.Category;
import com.record.backend.dto.category.CategoryPostsDto;

import lombok.Data;

@Data
public class CategoryResponsetDto {

	private Long categoryId;
	private Long userId;
	private String categoryName;

	private List<CategoryPostsDto> posts;

	public CategoryResponsetDto(Category category) {
		categoryId = category.getId();
		//userId = category.getUser().getId();
		categoryName = category.getName();
		posts = category.getPosts().stream()
			.map(post -> new CategoryPostsDto(post))
			.collect(Collectors.toList());
	}
}
