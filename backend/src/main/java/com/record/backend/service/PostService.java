package com.record.backend.service;

import java.util.List;

import com.record.backend.domain.category.Category;
import com.record.backend.domain.post.Exposure;
import com.record.backend.domain.user.User;
import com.record.backend.dto.post.PostUpdateDto;
import com.record.backend.repository.CategoryRepository;
import com.record.backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.record.backend.domain.post.Post;
import com.record.backend.repository.PostRepository;
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
//		Category category = categoryRepository.findByUserAndName(user, requestDto.getCategory()).get();

		return postRepository.save(requestDto.toEntity(user)).getId();
//		return postRepository.save(requestDto.toEntity(user, category, exposure)).getId();
	}

	@Transactional
	public Long updatePost(PostUpdateDto updateDto) {
		Post post = postRepository.findById(updateDto.getPost_id()).get();

		post.updatePost(updateDto);

		return post.getId();
	}

//
//	public List<Post> findAllPost() {
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


}
