package com.record.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.record.backend.domain.comment.Comment;
import com.record.backend.domain.post.Post;
import com.record.backend.domain.user.User;
import com.record.backend.dto.comment.CommentUpdateDto;
import com.record.backend.exception.IllegalUserException;
import com.record.backend.repository.comment.CommentRepository;
import com.record.backend.repository.post.PostRepository;
import com.record.backend.repository.user.UserRepository;
import com.record.backend.dto.comment.CommentSaveRequestDto;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentService {

	private final CommentRepository commentRepository;
	private final UserRepository userRepository;
	private final PostRepository postRepository;

	private final int MAX_LENGTH = 150;

	@Transactional
	public Long saveComment(Long postId, Long userId, CommentSaveRequestDto requestDto) {
		Comment comment = requestDto.toEntity();
		validateNotNull(requestDto.getContent());
		comment.setPost(findPost(postId));
		comment.setUser(findUser(userId));
		return commentRepository.save(comment).getId();
	}

	//수정
	@Transactional
	public Long updateComment(Long id, CommentUpdateDto updateDto) {
		Comment comment = findComment(id);
		validateNotNull(updateDto.getContent());
		comment.setContent(updateDto.getContent());
		return comment.getId();
	}

	//삭제
	public void deleteComment(Long id) {
		Comment comment = findComment(id);
		commentRepository.deleteById(comment.getId());
	}

	/**
	 * 검증
	 */
	public Comment findComment(Long id) {
		return commentRepository.findById(id)
			.orElseThrow(() -> new IllegalUserException("찾는 댓글 없습니다."));
	}

	public User findUser(Long id) {
		return userRepository.findById(id)
			.orElseThrow(() -> new IllegalUserException("찾는 멤버 없습니다."));
	}

	private Post findPost(Long postId) {
		return postRepository.findById(postId)
			.orElseThrow(() -> new IllegalUserException("찾는 포스트 없습니다."));
	}

	private void validateNotNull(String value) {
		if (value.length() > MAX_LENGTH) {
			throw new IllegalUserException("댓글 내용이 비어있습니다.");
		}
	}
}
