package com.record.backend.apiController;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.stream.Collectors;

import com.record.backend.domain.category.Category;
import com.record.backend.dto.category.CategoryResponseDto;
import com.record.backend.dto.post.PostResponseDto;
import com.record.backend.dto.post.PostSaveRequestDto;
import com.record.backend.dto.post.PostUpdateDto;
import org.springframework.web.bind.annotation.*;

import com.record.backend.domain.post.Post;
import com.record.backend.repository.category.CategoryRepository;
import com.record.backend.repository.post.PostRepository;
import com.record.backend.service.CategoryService;
import com.record.backend.service.PostService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PostApiController {

	private final PostService postService;
	private final PostRepository postRepository;
	private final CategoryRepository categoryRepository;

	//작성시 카테고리 내려주는 부분 추가해야함
	@PostMapping("/board/posts")
	public Long save(@RequestBody PostSaveRequestDto requestDto) {
		return postService.savePost(requestDto);
	}

	@GetMapping("/board/posts/write")
	public Result ShowCategoriesToPostWrite() {
		List<Category> allCategory = categoryRepository.findAll();
		List<CategoryResponseDto> collect = allCategory.stream()
			.map(CategoryResponseDto::new)
			.collect(Collectors.toList());

		return new Result(collect);
	}

	@GetMapping("/board/posts")
	public Result findAllPosts() {
		List<Post> allPost = postRepository.findAll();
		List<PostResponseDto> collect = allPost.stream()
				.map(PostResponseDto::new)
				.collect(toList());

		return new Result(collect);
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

	@Data
	@AllArgsConstructor
	static class Result<T> {
		private T data;
	}
}
