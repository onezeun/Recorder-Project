package com.record.backend.apiController;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.record.backend.domain.comment.Comment;
import com.record.backend.domain.post.Post;
import com.record.backend.dto.category.CategoryUpdateDto;
import com.record.backend.dto.comment.CommentDto;
import com.record.backend.dto.comment.CommentResponseDto;
import com.record.backend.dto.comment.CommentSaveRequestDto;
import com.record.backend.dto.comment.CommentUpdateDto;
import com.record.backend.dto.user.UserResponseDto;
import com.record.backend.repository.comment.CommentQueryRepository;
import com.record.backend.repository.comment.CommentRepository;
import com.record.backend.repository.post.PostRepository;
import com.record.backend.service.CommentService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CommentApiController {

	private final CommentService commentService;
	private final CommentRepository commentRepository;
	private final CommentQueryRepository commentQueryRepository;

	@PostMapping("/board/comments/posts/{post_id}/users/{user_id}")
	public Long saveComment(@PathVariable Long postId, @PathVariable Long userId, CommentSaveRequestDto requestDto) {
		return commentService.saveComment(postId, userId, requestDto);
	}

	@GetMapping("/board/comments")
	public List<CommentDto> findAllComments(
		@RequestParam(value = "offset", defaultValue = "0") int offset,
			@RequestParam(value = "limit", defaultValue = "100") int limit) {
		//XtoOne은 fetch join으로 가져옴
		List<Comment> comments = commentQueryRepository.findAllWithUserPost(offset, limit);

		List<CommentDto> result = comments.stream()
			.map(o -> new CommentDto(o))
			.collect(Collectors.toList());

		return result;
	}


	@PutMapping("/comments/{comment_id}")
	public Long updateComment (@PathVariable("comment_id") Long commentId, CommentUpdateDto updateDto) {
		return commentService.updateComment(commentId, updateDto);
	}

	@DeleteMapping("/comments/{comment_id}")
	public void deleteComment (@PathVariable("comment_id") Long commentId) {
		commentService.deleteComment(commentId);
	}

	@Data
	@AllArgsConstructor
	static class Result<T> {
		private T data;
	}
}
