package com.record.backend.apiController;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.record.backend.dto.comment.CommentResponseDto;
import com.record.backend.dto.comment.CommentSaveRequestDto;
import com.record.backend.service.CommentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CommentApiController {

	private final CommentService commentService;

	@PostMapping("/comments/posts/{post_id}/users/{user_id}")
	public String saveComment(@PathVariable Long postId, @PathVariable Long userId, CommentSaveRequestDto requestDto) {
		commentService.saveComment(postId, userId, requestDto);
		return "redirect:/board/posts/" + postId;
	}

	@GetMapping("board/comments/{comment_id}")
	@ResponseBody
	public CommentResponseDto getComment (@PathVariable Long id) {
		return commentService.getComment(id);
	}

	//json 확인용
	@GetMapping("/comments")
	@ResponseBody
	public Page<CommentResponseDto> getAllComments (Pageable pageable) {
		return commentService.getAllComments(pageable);
	}

	@PutMapping("/comments/{comment_id}")
	public String updateComment (@PathVariable Long id, CommentResponseDto responseDto) {
		Long postId = responseDto.getPost_id();
		commentService.updateComment(id, responseDto);
		return "redirect:/board/posts" + postId;
	}

	@DeleteMapping("/comments/{comment_id}")
	public String deleteComment (@PathVariable Long id) {
		Long postId = commentService.findComment(id).getPost().getId();

		commentService.deleteComment(id);
		return "redirect:/boards/posts/" + postId;
	}
}
