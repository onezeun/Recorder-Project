package com.record.backend.dto.post;

import com.record.backend.domain.category.Category;
import com.record.backend.domain.post.Exposure;
import com.record.backend.domain.post.Post;
import com.record.backend.domain.post.PostTag;
import com.record.backend.domain.user.User;

import com.record.backend.dto.tag.TagDto;
import com.record.backend.repository.CategoryRepository;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class PostSaveRequestDto {

	private Long user_id;
	private String title;
	private String content;
	private String summary;
//	private String category;
	private String exposure;
//	private List<TagDto> postTagList;
//	private byte[] thumbnail_image;

	public Post toEntity(User user, Exposure exposure) {
		return Post.builder()
				.user(user)
				.title(this.title)
				.content(this.content)
				.summary(this.summary)
//				.category(category)
				.exposure(exposure)
				.build();
	}

}
