package com.record.backend.dto.tag;

import java.util.List;
import java.util.stream.Collectors;

import com.record.backend.domain.tag.Tag;
import com.record.backend.domain.tag.Tags;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TagResponse {

	private Long id;
	private String name;

	public static TagResponse of(Tag tag) {
		return TagResponse.builder()
			.id(tag.getId())
			.name(tag.getTagNameValue())
			.build();
	}

	public static TagResponse of(TagDto tag) {
		return TagResponse.builder()
			.id(tag.getId())
			.name(tag.getName())
			.build();
	}

	public static List<TagResponse> listOf(Tags tags) {
		return tags.stream()
			.map(TagResponse::of)
			.collect(Collectors.toList());
	}

	public static List<TagResponse> listOf(List<TagDto> tagDtos) {
		return tagDtos.stream()
			.map(TagResponse::of)
			.collect(Collectors.toList());
	}
}
