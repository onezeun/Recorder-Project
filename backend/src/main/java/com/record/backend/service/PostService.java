package com.record.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
