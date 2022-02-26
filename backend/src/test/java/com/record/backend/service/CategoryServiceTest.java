package com.record.backend.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.record.backend.domain.category.Category;
import com.record.backend.domain.user.User;
import com.record.backend.exception.IllegalUserException;
import com.record.backend.repository.category.CategoryRepository;
import com.record.backend.dto.category.CategoryResponseDto;
import com.record.backend.dto.category.CategorySaveRequestDto;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CategoryServiceTest {

	@Autowired CategoryService categoryService;
	@Autowired CategoryRepository categoryRepository;
	@Autowired
	EntityManager em;

	//saveId
	private CategorySaveRequestDto createCategoryDTO(String testName) {
		CategorySaveRequestDto requestDto = new CategorySaveRequestDto();
		requestDto.setCategory_name(testName);
		return requestDto;
	}

	//Find Category
	private Category findCategory(Long id){
		return categoryRepository.findById(id)
			.orElseThrow(IllegalArgumentException::new);
	}

	@Test
	//@Rollback(value = false)
	public void 카테고리_저장_테스트() {
		//given
		CategorySaveRequestDto requestDto = createCategoryDTO("testName");
		Long saveId = categoryService.saveCategory(requestDto);

		//when
		Category category = findCategory(saveId);

		//then
		assertThat(category.getName()).isEqualTo("testName");
	}

	@Test
	//@Rollback(value = false)
	public void 카테고리_업데이트_테스트() {

		User user = new User();
		em.persist(user);

		//given
		CategorySaveRequestDto requestDto = createCategoryDTO("testName");
		Long saveId = categoryService.saveCategory(requestDto);

		Category category = findCategory(saveId);
		CategoryResponseDto targetCategory = new CategoryResponseDto(category);
		targetCategory.setCategory_name("updateName");

		//when
		Long updateId = categoryService.updateCategory(saveId, targetCategory);
		Category updatedCategory = findCategory(updateId);

		//then
		assertThat(updatedCategory.getName()).isEqualTo("updateName");
	}

	@Test
	public void 카테고리_삭제_테스트() {
		//given
		CategorySaveRequestDto requestDto = createCategoryDTO("testName");
		Long saveId = categoryService.saveCategory(requestDto);

		//when
		categoryService.deleteCategoryOne(saveId);

		//then
		IllegalUserException e =
			assertThrows(IllegalUserException.class,
				() -> categoryService.findCategory(saveId));
		assertThat(e.getMessage()).isEqualTo("카테고리 이름을 찾을 수 없습니다.");
	}

}