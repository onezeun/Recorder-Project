package com.record.backend.dto.tag;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TagRequest {

	@NotNull
	@PositiveOrZero
	private Long id;

	@NotBlank
	@Length(max = 20)
	private String name;
}
