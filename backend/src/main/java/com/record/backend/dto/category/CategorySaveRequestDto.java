package com.record.backend.dto.category;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

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

	@NotBlank
	@Length(max = 10)
	private String categoryName;
	private List<Post> postList;

	@Builder
	public CategorySaveRequestDto(String categoryName) {
		//this.user = user;
		this.categoryName = categoryName;
	}

	public Category toEntity() {
		return Category.builder()
			.user(user)
			.name(categoryName)
			.build();
	}
}
