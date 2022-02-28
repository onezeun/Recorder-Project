package com.record.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.record.backend.domain.category.Category;
import com.record.backend.dto.category.CategoryUpdateDto;
import com.record.backend.exception.IllegalUserException;
import com.record.backend.repository.category.CategoryRepository;
import com.record.backend.dto.category.CategoryResponseDto;
import com.record.backend.dto.category.CategorySaveRequestDto;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CategoryService {

	private final CategoryRepository categoryRepository;

	/**
	 * 카테고리 생성하기
	 */
	@Transactional
	public Long saveCategory(CategorySaveRequestDto requestDto) {
		Category category = requestDto.toEntity();
		validateExistCategoryName(requestDto.getCategoryName());
		return categoryRepository.save(category).getId();
	}

	/**
	 * 카테고리 수정
	 */
	@Transactional
	public Long updateCategory(Long categoryId, CategoryUpdateDto updateDto) {
		Category category = findCategory(categoryId);
		validateExistCategoryName(updateDto.getCategoryName());
		category.setName(updateDto.getCategoryName());
		return category.getId();
	}

	/**
	 * 포스트 작성시 카테고리 목록 불러오기
	 */
	public List<CategoryResponseDto> showCategoriesToPost() {
		return categoryRepository.findAll()
			.stream()
			.map(CategoryResponseDto::new)
			.collect(Collectors.toList());
	}

	/**
	 * 카테고리 삭제
	 */
	@Transactional
	public void deleteCategory(Long id) {
		categoryRepository.delete(findCategory(id));
	}

	/**
	 * 카테고리 조회
	 */
	public Category findCategory(Long categoryId) {
		return categoryRepository.findById(categoryId)
			.orElseThrow(() -> new IllegalUserException("카테고리를 찾을 수 없습니다."));
	}

	/**
	 * 사용자 검증
	 */
	private void validateExistCategoryName(String categoryName) {
		if (categoryRepository.findByName(categoryName).isPresent()) {
			throw new IllegalUserException("이미 존재하는 카테고리입니다.");
		}
	}
}
