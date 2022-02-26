package com.record.backend.repository.comment;

import org.springframework.data.jpa.repository.JpaRepository;

import com.record.backend.domain.comment.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
