package com.record.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.record.backend.domain.category.Category;
import com.record.backend.domain.post.Post;
import com.record.backend.exception.IllegalUserException;
import com.record.backend.repository.CategoryRepository;
import com.record.backend.repository.dto.CategoryResponseDto;
import com.record.backend.repository.dto.CategorySaveRequestDto;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CategoryService {

	private final CategoryRepository categoryRepository;

	@Transactional
	public Long saveCategory(CategorySaveRequestDto requestDto) {
		Category category = requestDto.toEntity();
		if (categoryRepository.findByUserAndName(requestDto.getUser(), requestDto.getCategory_name())) {
			throw new IllegalUserException("한 블로그에 같은 카테고리는 없다.");
		}
		if (category.getUser().getCategoryList().size() >= 10) {
			throw new IllegalUserException("카테고리는 열개가 최대임.");
		}
		return categoryRepository.save(category).getId();
	}

	@Transactional
	public Category editCategory(Category category) {
		return null;
	}

	public Category getCategoryById(Long id) throws IllegalArgumentException {
		Category category = categoryRepository.getById(id);

		if (category == null) {
			throw new IllegalArgumentException("카테고리를 찾을 수 없습니다.");
		}
		return category;
	}

	public List<Category> findCategories() {
		return categoryRepository.findAll();
	}

	public Optional<Category> findCategory(Long id) {
		return categoryRepository.findById(id);
	}

	@Transactional
	public void delete(Category category) {
		categoryRepository.delete(category);
	}
}
