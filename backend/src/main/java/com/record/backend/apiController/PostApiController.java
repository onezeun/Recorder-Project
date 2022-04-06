package com.record.backend.apiController;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.record.backend.auth.security.CurrentUser;
import com.record.backend.auth.security.UserPrincipal;
import com.record.backend.domain.post.Post;
import com.record.backend.auth.dto.loginlogout.response.ApiResponse;
import com.record.backend.dto.post.PostDto;
import com.record.backend.dto.post.request.PostSaveRequestDto;
import com.record.backend.dto.post.request.PostUpdateRequestDto;
import com.record.backend.dto.post.response.PostResponseDto;
import com.record.backend.dto.post.response.PostUpdateResponseDto;
import com.record.backend.repository.PostRepository;
import com.record.backend.repository.query.PostQueryRepository;
import com.record.backend.service.PostService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PostApiController {

	private final PostService postService;
	private final PostQueryRepository postQueryRepository;


	//포스트 생성
	@PostMapping("/board/posts")
	//@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> savePost(@RequestBody PostSaveRequestDto requestDto) {
		Post post = postService.savePost(requestDto);

		return ResponseEntity.ok(new ApiResponse(true, "Post Created Successfully!"));
	}

	//수정
	@PutMapping("/board/posts/{post_id}")
	public PostUpdateResponseDto updatePost( @PathVariable("post_id") Long postId,
		@RequestBody PostUpdateRequestDto updateDto) {
		return postService.updatePost(postId, updateDto);
	}

	//조회
	@GetMapping("/board/posts")
	public Result allPosts() {
		List<PostResponseDto> allPost = postService.findAllPost();

		return new Result(allPost);
	}

	//사용자 블로그에 들어갔을 시, 카테고리별로 누르면 해당 카테고리에 있는 포스트가 불려온다.
	@GetMapping("/board/posts/v1")
	public Result findAllCategoryPosts(
		@RequestParam(value = "offset", defaultValue = "0") int offset,
		@RequestParam(value = "limit", defaultValue = "100") int limit) {
		//XtoOne은 fetch join으로 가져옴
		List<Post> posts = postQueryRepository.findAllWithUserCategory(offset, limit);

		List<PostDto> result = posts.stream()
			.map(o -> new PostDto(o))
			.collect(Collectors.toList());

		return new Result(result);
	}

	//하나만 조회
	@GetMapping("/board/posts/{post_id}")
	public PostResponseDto findPost(@CurrentUser UserPrincipal currentUser, @PathVariable("post_id") Long postId) {
		//Post findPost = postRepository.findById(postId).get();
		Post findPost = postService.getPostById(postId, currentUser);
		return new PostResponseDto(findPost);
	}

	//삭제
	@DeleteMapping("/board/posts/{post_id}")
	public void deletePost(@PathVariable("post_id") Long postId) {
		postService.deletePost(postId);

	}

	@Data
	@AllArgsConstructor
	static class Result<T> {
		private T data;
	}
}
