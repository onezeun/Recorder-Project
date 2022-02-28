package com.record.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.record.backend.domain.comment.Comment;
import com.record.backend.exception.IllegalUserException;
import com.record.backend.repository.comment.CommentRepository;
import com.record.backend.repository.post.PostRepository;
import com.record.backend.repository.user.UserRepository;
import com.record.backend.dto.comment.CommentResponseDto;
import com.record.backend.dto.comment.CommentSaveRequestDto;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentService {

	private final CommentRepository commentRepository;
	private final UserRepository userRepository;
	private final PostRepository postRepository;

	public Long saveComment(Long postId, Long userId, CommentSaveRequestDto requestDto) {
		Comment comment = requestDto.toEntity();
		comment.setUser(userRepository.findById(userId)
			.orElseThrow(() -> new IllegalUserException("멤버가 없습니다.")));
		comment.setPost(postRepository.findById(postId)
			.orElseThrow(() -> new IllegalUserException("포스트가 없습니다.")));
		return commentRepository.save(comment).getId();
	}

	//가져오기
	public Page<CommentResponseDto> getAllComments(Pageable pageable) {
		PageRequest id = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("id").descending());
		Page<CommentResponseDto> commentList = commentRepository.findAll(id).map(CommentResponseDto::new);
		return commentList;
	}

	//수정
	public Long updateComment(Long id, CommentResponseDto responseDto) {
		Comment comment = findComment(id);

		comment.setContent(responseDto.getContent());
		return comment.getId();
	}

	//삭제
	public void deleteComment(Long id) {
		Comment comment = findComment(id);

		commentRepository.deleteById(comment.getId());
	}

	public CommentResponseDto getComment(Long id) {
		Comment comment = findComment(id);

		return new CommentResponseDto(comment);
	}

	public Comment findComment(Long id) {
		return commentRepository.findById(id)
			.orElseThrow(() -> new IllegalUserException("찾는 댓글이 없습니다."));
	}
}
