package com.record.backend.apiController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.record.backend.repository.dto.PostSaveRequestDto;
import com.record.backend.service.PostService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PostApiController {

	private final PostService postService;

	@PostMapping("/board/posts")
	public Long save(@RequestBody PostSaveRequestDto requestDto) {
		return postService.save(requestDto);
	}
}
