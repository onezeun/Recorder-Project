package com.record.backend.apiController;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.record.backend.Member;
import com.record.backend.domain.category.Category;
import com.record.backend.repository.CategoryRepository;
import com.record.backend.repository.dto.CategoryResponseDto;
import com.record.backend.repository.dto.CategorySaveRequestDto;
import com.record.backend.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CategoryApiController {

	private final CategoryRepository categoryRepository;
	private final CategoryService categoryService;

	// 생성
	@PostMapping("/board/categories")
	@ResponseBody
	public Long saveCategory(CategorySaveRequestDto requestDto) {
		return categoryService.saveCategory(requestDto);
	}

	//조회
	@GetMapping("/board/categories")
	public List<Category> Categories() {
		List<Category> categories = categoryRepository.findAll();
		for (Category category : categories) {
			category.getName();
		}
		return categories;
	}

	//수정
	@PutMapping("/board/categories/{category_id}")
	@ResponseBody
	public Long updateCategory(
		@PathVariable(name = "category_name") @NotBlank String categoryName
		, CategorySaveRequestDto requestDto) {
		return categoryService.updateCategory(categoryName, requestDto);
	}

	//삭제
	@DeleteMapping("/board/categories/{category_id}")
	@ResponseBody
	public void deleteCategory(
		@PathVariable(name = "category_name") @NotBlank String categoryName) {
		categoryService.deleteCategory(categoryName);
	}
}
