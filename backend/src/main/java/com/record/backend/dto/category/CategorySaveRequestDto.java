package com.record.backend.dto.category;

import java.util.List;

import com.record.backend.domain.category.Category;
import com.record.backend.domain.post.Post;
import com.record.backend.domain.user.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class CategorySaveRequestDto {

	private Long categoryId;
	private User user;
	private String category_name;
	private List<Post> postList;

	@Builder
	public CategorySaveRequestDto(User user, String category_name) {
		this.user = user;
		this.category_name = category_name;
		//this.postList = postList;
	}

	public Category toEntity() {
		return Category.builder()
			.user(user)
			.name(category_name)
			//.postList(postList)
			.build();
	}
}
