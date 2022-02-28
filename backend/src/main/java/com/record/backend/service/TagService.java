package com.record.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.record.backend.domain.tag.FilterCriteria;
import com.record.backend.domain.tag.Tag;
import com.record.backend.domain.tag.TagName;
import com.record.backend.dto.tag.TagRequest;
import com.record.backend.dto.tag.TagResponse;
import com.record.backend.repository.tag.TagQueryRepository;
import com.record.backend.repository.tag.TagRepository;

@Service
@Transactional(readOnly = true)
public class TagService {

	/*private final TagRepository tagRepository;
	private final TagQueryRepository tagQueryRepository;

	public TagService(TagRepository tagRepository, TagQueryRepository tagQueryRepository) {
		this.tagRepository = tagRepository;
		this.tagQueryRepository = tagQueryRepository;
	}

	public Tags convertTags(List<TagRequest> tagRequests) {
		List<Tag> tags = tagRequests.stream()
			.map(TagRequest::getName)
			.map(TagName::of)
			.distinct()
			.map(tagName -> tagRepository.findByTagName(tagName).orElse(Tag.of(tagName)))
			.collect(Collectors.toList());
		return Tag.of(tags);
	}

	@Cacheable(value = "filterTags", key = "#filterCriteria.post")
	public List<TagResponse> findAllTagsByPostName(FilterCriteria filterCriteria) {
		String keyword = filterCriteria.getPost();
		if (filterCriteria.isEmpty()) {
			return TagResponse.listOf(Tags.empty());
		}

		List<Tag> findTags = tagQueryRepository.findAllByContainsPostName(keyword);
		return TagResponse.listOf(Tags.of(findTags));
	}*/
}
