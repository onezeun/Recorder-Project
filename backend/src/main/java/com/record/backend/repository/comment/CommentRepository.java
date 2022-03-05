package com.record.backend.repository.comment;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.record.backend.domain.comment.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	//List<Comment> findCommentsByPostId(Long postId, Pageable pageable);
}
