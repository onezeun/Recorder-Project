package com.record.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.record.backend.domain.post.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

	List<Post> findAllByUserId(Long userId);
}
