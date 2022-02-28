package com.record.backend.repository.tag;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.record.backend.domain.tag.Tag;
import com.record.backend.dto.tag.TagDto;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class TagQueryRepository {

	@Autowired
	EntityManager em;


	public List<TagDto> findAllTagContatining(String keyword) {
		if (Objects.isNull(keyword)) {
			return Collections.emptyList();
		}
		em.createQuery("");

		return null;
	}

	//
	public List<Tag> findAllByContainsPostName(String postName) {
		if (Objects.isNull(postName)) {
			return Collections.emptyList();
		}
		return null;
	}


}
