package com.record.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.record.backend.domain.category.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {
	Optional<Category> findByName(String categoryName);

	List<Category> findAllByUserId(Long userId);
}

