package com.record.backend.service;

import java.util.List;

import com.record.backend.dto.post.PostUpdateDto;
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

	private final PostRepository postRepository;

	@Transactional
	public Long writePost(PostSaveRequestDto requestDto) {
		return postRepository.save(requestDto.toEntity()).getId();
	}

	@Transactional
	public Long updatePost(PostUpdateDto updateDto) {
		Post post = postRepository.findById(updateDto.getPost_id()).get();

		post.updatePost(updateDto);

		return post.getId();
	}


	public List<Post> findAllPost() {
		return postRepository.findAll();
	}


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
