package com.record.backend.apiController;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.record.backend.domain.category.Category;
import com.record.backend.dto.category.CategoryUpdateDto;
import com.record.backend.repository.category.CategoryRepository;
import com.record.backend.dto.category.CategoryResponseDto;
import com.record.backend.dto.category.CategorySaveRequestDto;
import com.record.backend.service.CategoryService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CategoryApiController {

	private final CategoryRepository categoryRepository;
	private final CategoryService categoryService;

	// 생성
	@PostMapping("/board/categories")
	@ResponseBody
	public Long saveCategory(@RequestBody CategorySaveRequestDto requestDto) {
		return categoryService.saveCategory(requestDto);
	}

	//조회
	@GetMapping("/board/categories")
	public Result Categories() {
		List<Category> allCategory = categoryRepository.findAll();
		List<CategoryResponseDto> collect = allCategory.stream()
			.map(CategoryResponseDto::new)
			.collect(Collectors.toList());

		return new Result(collect);
	}

	@GetMapping("/board/cateogries/{category_id}")
	public CategoryResponseDto findCategory(@PathVariable("category_id") Long categoryId) {
		Category findCategory = categoryRepository.findById(categoryId).get();
		return new CategoryResponseDto(findCategory);
	}

	//수정
	@PutMapping("/board/categories/{category_id}")
	public Long updateCategory(@PathVariable(name = "category_id") Long categoryId, CategoryUpdateDto updateDto) {
		return categoryService.updateCategory(categoryId, updateDto);
	}

	//삭제
	@DeleteMapping("/board/categories/{category_id}")
	public void deleteCategory(@PathVariable(name = "category_id") Long categoryId) {
		categoryService.deleteCategory(categoryId);
	}

	@Data
	@AllArgsConstructor
	static class Result<T> {
		private T data;
	}
}
