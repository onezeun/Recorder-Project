package com.record.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.record.backend.domain.comment.Comment;
import com.record.backend.domain.post.Post;
import com.record.backend.domain.user.User;
import com.record.backend.dto.comment.request.CommentSaveRequestDto;
import com.record.backend.dto.comment.request.CommentUpdateRequestDto;
import com.record.backend.dto.comment.response.CommentUpdateResponseDto;
import com.record.backend.repository.CommentRepository;
import com.record.backend.repository.PostRepository;
import com.record.backend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class CommentService {

	private final CommentRepository commentRepository;
	private final UserRepository userRepository;
	private final PostRepository postRepository;

	//생성
	@Transactional
	public Long saveComment(CommentSaveRequestDto requestDto) {
		User user = userRepository.findById(requestDto.getUser().getId()).get();
		Post post = postRepository.findById(requestDto.getPost().getId()).get();
		requestDto.setUser(user);
		requestDto.setPost(post);

		return commentRepository.save(requestDto.toEntity()).getId();
	}

	//수정
	@Transactional
	public CommentUpdateResponseDto updateComment(Long commentId, CommentUpdateRequestDto updateDto) {
		Comment findComment = commentRepository.findById(commentId).get();
		findComment.setContent(updateDto.getContent());
		return new CommentUpdateResponseDto(findComment.getId(), findComment.getContent());
	}

	//삭제
	@Transactional
	public void deleteComment(Long commentId) {
		commentRepository.deleteById(commentId);
	}
}
