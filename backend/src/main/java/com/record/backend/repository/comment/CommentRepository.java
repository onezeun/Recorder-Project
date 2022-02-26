package com.record.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.record.backend.domain.comment.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
