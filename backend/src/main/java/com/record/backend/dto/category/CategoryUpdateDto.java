package com.record.backend.dto.category;

import com.record.backend.domain.category.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryUpdateDto {

	private Long categoryId;
	private Long userId;
	private String categoryName;
}
