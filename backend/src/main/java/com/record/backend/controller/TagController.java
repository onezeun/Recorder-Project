package com.record.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.record.backend.domain.tag.FilterCriteria;
import com.record.backend.dto.tag.TagResponse;
import com.record.backend.service.TagService;

@RestController
@RequestMapping("/tags")
public class TagController {

	private final TagService tagService;

	public TagController(TagService tagService) {
		this.tagService = tagService;
	}

	@GetMapping
	public ResponseEntity<List<TagResponse>> findAllTagsByPostName(@RequestParam String post) {
		FilterCriteria filterCriteria = new FilterCriteria(post);
		List<TagResponse> responses = tagService.findAllTagsByPostName(filterCriteria);
		return ResponseEntity.ok(responses);
	}
}
