package com.record.backend.repository.post;

import org.springframework.data.jpa.repository.JpaRepository;

import com.record.backend.domain.post.PostTag;

public interface PostTagRepository extends JpaRepository<PostTag, Long> {
}
