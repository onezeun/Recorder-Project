package com.record.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.record.backend.domain.category.Category;
import com.record.backend.domain.post.Post;
import com.record.backend.domain.user.User;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	Optional<Category> findByUserAndName(User user_id, String category_name);

	Optional<Category> findByName(String categoryName);

	int deleteByName(String category);
}
