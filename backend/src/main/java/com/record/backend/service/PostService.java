package com.record.backend.service;

import com.record.backend.domain.user.User;
import com.record.backend.dto.post.LikeResponseDto;
import com.record.backend.dto.post.PostUpdateDto;
import com.record.backend.exception.IllegalUserException;
import com.record.backend.repository.category.CategoryRepository;
import com.record.backend.repository.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.record.backend.domain.post.Post;
import com.record.backend.repository.post.PostRepository;
import com.record.backend.dto.post.PostSaveRequestDto;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

	private final UserRepository userRepository;
	private final PostRepository postRepository;
	private final CategoryRepository categoryRepository;

	@Transactional
	public Long savePost(PostSaveRequestDto requestDto) {
		User user = userRepository.findById(requestDto.getUser_id()).get();
		requestDto.setUser(user);

		return postRepository.save(requestDto.toEntity()).getId();
	}

	@Transactional
	public Long updatePost(Long postId, PostUpdateDto updateDto) {

		Post findPost = postRepository.findById(postId).get();
		findPost.updatePost(updateDto);

		return findPost.getId();
	}

	@Transactional
	public void deletePost(Long postId) {
		postRepository.deleteById(postId);
	}

	//==like 로직==//
	@Transactional
	public LikeResponseDto postLike(User user, Long postId) {
		User source = findUserByDomian(user.getDomain());
		Post target = findPostById(postId);

		target.postLike(source);
		return new LikeResponseDto(target.getLikeCounts(), true);
	}

	@Transactional
	public LikeResponseDto unPostLike(User user, Long postId) {
		User source = findUserByDomian(user.getDomain());
		Post target = findPostById(postId);

		target.unPostLike(source);
		return new LikeResponseDto(target.getLikeCounts(), false);
	}

	private Post findPostById(Long postId) {
		return postRepository.findById(postId)
			.orElseThrow(IllegalUserException::new);
	}
//package com.record.backend.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.record.backend.domain.post.Post;
//import com.record.backend.repository.PostRepository;
//import com.record.backend.repository.dto.PostSaveRequestDto;
//
//import lombok.RequiredArgsConstructor;
//
//@Service
//@Transactional(readOnly = true)
//@RequiredArgsConstructor
//public class PostService {
//
//	private final PostRepository postRepository;
//
//	@Transactional
//	public Long save(PostSaveRequestDto requestDto) {
//		return postRepository.save(requestDto.toEntity()).getId();
//	}
//
//	@Transactional
//	public Post writePost(Post post) {
//		return null;
//		//	return postRepository.save(post);
//	}
//
//	@Transactional
//	public Post editPost(Post post) {
///*		post = getPostById(post.getUser().getId());
//		post.setTitle(post.getTitle());
//		post.setContent(post.getContent());
//		post.setUpdate_date(post.getUpdate_date());
//		//post.setCategoryId
//
//		return post;
//*/
//		return null;
//	}
//
//	private Post getPostById(Long id) throws IllegalArgumentException {
//		Post post = postRepository.getById(id);
//
//		if (post == null) {
//			throw new IllegalArgumentException("사용자를 찾을 수 없습니다.");
//		}
//		return post;
//	}
//
//	public List<Post> findPosts() {
//		return postRepository.findAll();
//	}
//
//	public Optional<Post> findPostById(Long id) {
//		return postRepository.findById(id);
//	}
//
//
//	@Transactional
//	public void delete(Post post) {
//		postRepository.delete(post);
//	}

	private User findUserByDomian(String domain) {
		return userRepository.findByDomain(domain)
			.orElseThrow(IllegalUserException::new);
	}

}
//
//
//}
