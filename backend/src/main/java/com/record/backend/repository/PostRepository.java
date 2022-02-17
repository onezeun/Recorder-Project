package com.record.backend.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.record.backend.domain.post.Post;
import com.record.backend.domain.user.User;

public interface PostRepository extends JpaRepository<Post, Long> {

	Page<Post> findByCategoryId(int categoryId, Pageable pageable);

	Page<Post> findByPostTagListTagName(String tagName, Pageable pageable);

	Page<Post> findByContentContaining(String query, Pageable pageable);

	Page<Post> findByTitleContaining(String title, Pageable pageable);

	Page<Post> findByTitleContainingOrContentContaining(
		String title, String content, Pageable pageable);

//	Optional<Post> findById(Long id);
}
