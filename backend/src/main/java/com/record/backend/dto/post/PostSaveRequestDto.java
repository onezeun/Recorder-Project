package com.record.backend.dto.post;

import com.record.backend.domain.category.Category;
import com.record.backend.domain.post.Exposure;
import com.record.backend.domain.post.Post;
import com.record.backend.domain.post.PostTag;
import com.record.backend.domain.user.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class PostSaveRequestDto {

	private User user;
	private Category category;
	private String title;
	private String content;
	private String summary;
	private Exposure exposure;
	private byte[] thumbnail_image;
	private List<PostTag> postTagList;


	@Builder
	public PostSaveRequestDto(User user, Category category, String title, String content,
							  String summary, Exposure exposure, byte[] thumbnail_image,
							  List<PostTag> postTagList) {
		this.user = user;
		this.category = category;
		this.title = title;
		this.content = content;
		this.summary = summary;
		this.exposure = exposure;
		this.thumbnail_image = thumbnail_image;
		this.postTagList = postTagList;
	}

	public Post toEntity() {
		return Post.builder()
				.user(user)
				.title(title)
				.content(content)
				.summary(summary)
				.exposure(exposure)
				.thumbnail_image(thumbnail_image)
				.postTagList(postTagList)
				.build();
	}
}
