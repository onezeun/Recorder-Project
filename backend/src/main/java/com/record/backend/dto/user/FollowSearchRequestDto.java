package com.record.backend.dto.user;

import lombok.Builder;

@Builder
public class FollowSearchRequestDto {

	private String domain;
	private Long page;
	private Long limit;

	private FollowSearchRequestDto() {

	}

	public FollowSearchRequestDto(String domain, Long page, Long limit) {
		this.domain = domain;
		this.page = page;
		this.limit = limit;
	}

	public String getDomain() {
		return domain;
	}

	public Long getPage() {
		return page;
	}

	public Long getLimit() {
		return limit;
	}
}
