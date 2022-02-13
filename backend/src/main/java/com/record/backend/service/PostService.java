package com.record.backend.service;

import java.util.List;
import java.util.Optional;

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
	public Long save(PostSaveRequestDto requestDto) {
		return postRepository.save(requestDto.toEntity()).getId();
	}

	@Transactional
	public Post writePost(Post post) {
		return null;
		//	return postRepository.save(post);
	}

	@Transactional
	public Post editPost(Post post) {
/*		post = getPostById(post.getUser().getId());
		post.setTitle(post.getTitle());
		post.setContent(post.getContent());
		post.setUpdate_date(post.getUpdate_date());
		//post.setCategoryId

		return post;
*/
		return null;
	}

	private Post getPostById(Long id) throws IllegalArgumentException {
		Post post = postRepository.getById(id);

		if (post == null) {
			throw new IllegalArgumentException("사용자를 찾을 수 없습니다.");
		}
		return post;
	}

	public List<Post> findPosts() {
		return postRepository.findAll();
	}

	public Optional<Post> findPostById(Long id) {
		return postRepository.findById(id);
	}


	@Transactional
	public void delete(Post post) {
		postRepository.delete(post);
	}


}
