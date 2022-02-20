package com.record.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.record.backend.domain.category.Category;
import com.record.backend.exception.IllegalUserException;
import com.record.backend.repository.CategoryRepository;
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
	/*@Transactional
	public Long saveCategory(CategorySaveRequestDto requestDto) {
		Category category = requestDto.toEntity();
		if (categoryRepository.findByUserAndName(requestDto.getUser(), requestDto.getCategory_name())) {
			throw new IllegalUserException("한 블로그에 같은 카테고리는 없다.");
		}
		if (category.getUser().getCategoryList().size() >= 10) {
			throw new IllegalUserException("카테고리는 열개가 최대임.");
		}
		return categoryRepository.save(category).getId();
	}*/
	@Transactional
	public Long saveCategory(CategorySaveRequestDto requestDto) {
		Category category = requestDto.toEntity();
		return categoryRepository.save(category).getId();
	}

	/**
	 * 카테고리 수정
	 */
	@Transactional
	public Long updateCategory(Long categoryId, CategoryResponseDto responseDto) {
		Category category = findCategory(categoryId);
		category.setName(responseDto.getCategory_name());
		return category.getId();

	}

	/**
	 * 모든 카테고리 찾기
	 */
	public List<Category> findAll() {
		return categoryRepository.findAll();
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
	 * @return
	 */
	@Transactional
	public int deleteCategory(String categoryName) {
		Category category = findCategory(categoryName);

		return categoryRepository.deleteByName(category.getName());
	}

	@Transactional
	public void deleteCategoryOne(Long categoryId) {
		Category category = findCategory(categoryId);
		categoryRepository.deleteById(category.getId());
	}

	/**
	 * 카테고리의 아이디 값으로 조회하여 해당 카테고리 이름을 반환
	 */
	public Category findCategory(String categoryName) {
		return categoryRepository.findByName(categoryName)
			.orElseThrow(() -> new IllegalUserException("카테고리 이름을 찾을 수 없습니다."));
	}

	public Category findCategory(Long categoryId) {
		return categoryRepository.findById(categoryId)
			.orElseThrow(() -> new IllegalUserException("카테고리 이름을 찾을 수 없습니다."));
	}

	/**
	 * 사용자 검증
	 */
/*	private void validateCategoryWithUser(User user, Category category) {
		if (!category.isAuthor(user)) {
			throw new RuntimeException("해당 블로그 사용자가 아님.");
		}
	}*/
}
