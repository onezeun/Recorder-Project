package com.record.backend.service;

import java.util.List;
import java.util.Optional;

import com.record.backend.repository.dto.PostResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.record.backend.domain.post.Post;
import com.record.backend.repository.PostRepository;
import com.record.backend.repository.dto.PostSaveRequestDto;

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
	public Post editPost(PostResponseDto postDto) {
		Post post = postRepository.findById(postDto.getPost_id()).get();

		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setSummary(postDto.getSummary());
		post.setExposure(postDto.getExposure());
		post.setThumbnail_image(postDto.getThumbnail_image());
		post.setPostTagList(postDto.getPostTagList());
		post.setUpdateDate();

		return post;
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
