package com.record.backend.apiController;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.record.backend.domain.category.Category;
import com.record.backend.dto.category.request.CategorySaveRequestDto;
import com.record.backend.dto.category.request.CategoryUpdateRequestDto;
import com.record.backend.dto.category.response.CategoryNameDto;
import com.record.backend.dto.category.response.CategoryResponseDto;
import com.record.backend.dto.category.response.CategoryUpdateResponseDto;
import com.record.backend.dto.loginlogout.response.ApiResponse;
import com.record.backend.repository.CategoryRepository;
import com.record.backend.service.CategoryService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CategoryApiController {

	private final CategoryRepository categoryRepository;

	private final CategoryService categoryService;

	//카테고리 생성
	@PostMapping("/board/categories/")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> createCategory(@RequestBody CategorySaveRequestDto requestDto) {

		Category category = categoryService.saveCategory(requestDto);

		return ResponseEntity.ok(new ApiResponse(true, "Category Created Successfully!"));
	}

	// user의 모든 카테고리 목록을 반환
	@GetMapping("/board/categories/users/{user_id}")
	public Result findAllCategoriesByUserId(@PathVariable("user_id") Long userId) {
		List<CategoryNameDto> categoryNameDtos = categoryService.showCategoryNames(userId);

		return new Result(categoryNameDtos);
	}

	//한개만 조회
	@GetMapping("/board/categories/{category_id}")
	public CategoryResponseDto findCategory(@PathVariable("category_id") Long categoryId) {
		Category findCategory = categoryRepository.findById(categoryId).get();
		return new CategoryResponseDto(findCategory);
	}

	//수정
	@PutMapping("/board/categories/{category_id}")
	public CategoryUpdateResponseDto updateCategory(@PathVariable("category_id") Long categoryId,
		@RequestBody CategoryUpdateRequestDto updateDto) {
		return categoryService.updateCategory(categoryId, updateDto);
	}

	//삭제
	@DeleteMapping("/board/categories/{category_id}")
	public void deleteCateogry(@PathVariable("category_id") Long categoryId) {
		categoryService.deleteCategory(categoryId);
	}



	@Data
	@AllArgsConstructor
	static class Result<T> {
		private T data;
	}
}
