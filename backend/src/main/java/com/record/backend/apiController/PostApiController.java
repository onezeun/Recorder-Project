package com.record.backend.apiController;

import static java.util.stream.Collectors.*;

import java.time.LocalDateTime;
import java.util.List;

import com.record.backend.repository.dto.PostResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.record.backend.domain.post.Post;
import com.record.backend.repository.PostRepository;
import com.record.backend.service.PostService;
import com.record.backend.service.UserService;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PostApiController {

	private final PostService postService;
	private final UserService userService;
	private final PostRepository postRepository;

/*	@PostMapping("/board/posts")
	public Long save(@RequestBody PostSaveRequestDto requestDto) {
		return postService.save(requestDto);
	}*/

	@GetMapping("api/board/posts")
	public List<PostResponseDto> findAllPosts() {
		List<Post> allPost = postRepository.findAll();
		List<PostResponseDto> result = allPost.stream()
			.map(o -> new PostResponseDto(o))
			.collect(toList());
		return result;
	}
}
