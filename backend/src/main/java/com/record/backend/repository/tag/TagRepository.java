package com.record.backend.repository.tag;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.record.backend.domain.tag.Tag;
import com.record.backend.domain.tag.TagName;

public interface TagRepository extends JpaRepository<Tag, Long> {

	Optional<Tag> findByTagName(TagName tagName);
}
