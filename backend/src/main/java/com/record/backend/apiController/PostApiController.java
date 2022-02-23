package com.record.backend.apiController;

import static java.util.stream.Collectors.*;

import java.util.List;

import com.record.backend.dto.post.PostResponseDto;
import com.record.backend.dto.post.PostSaveRequestDto;
import com.record.backend.dto.post.PostUpdateDto;
import org.springframework.web.bind.annotation.*;

import com.record.backend.domain.post.Post;
import com.record.backend.repository.PostRepository;
import com.record.backend.service.PostService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PostApiController {

	private final PostService postService;
	private final PostRepository postRepository;

	@PostMapping("/board/posts")
	public Long save(@RequestBody PostSaveRequestDto requestDto) {
		return postService.savePost(requestDto);
	}

	@GetMapping("/board/posts")
	public List<PostResponseDto> findAllPosts() {
		List<Post> allPost = postRepository.findAll();
		List<PostResponseDto> result = allPost.stream()
				.map(o -> new PostResponseDto(o))
				.collect(toList());

		return result;
	}

	@GetMapping("/board/posts/{post_id}")
	public PostResponseDto findPost(@PathVariable("post_id") Long postId) {
		Post findPost = postRepository.findById(postId).get();
		return new PostResponseDto(findPost);
	}

	@PutMapping("/board/posts/{post_id}")
	public Long update(@PathVariable("post_id") Long postId, @RequestBody PostUpdateDto updateDto) {
		return postService.updatePost(postId, updateDto);
	}

	@DeleteMapping("/board/posts/{post_id}")
	public void delete(@PathVariable("post_id") Long postId) {
		postService.deletePost(postId);
	}
}
