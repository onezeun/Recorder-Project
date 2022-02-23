package com.record.backend.dto.post;

import com.record.backend.domain.category.Category;
import com.record.backend.domain.post.Exposure;
import com.record.backend.domain.post.Post;
import com.record.backend.domain.post.PostTag;
import com.record.backend.domain.user.User;

import com.record.backend.dto.tag.TagDto;
import com.record.backend.repository.CategoryRepository;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class PostSaveRequestDto {

	private User user;

	@NotEmpty
	private Long user_id;

	@NotEmpty
	@Size(min = 1, max = 20)
	private String title;

	@NotEmpty
	@Size(min = 1)
	private String content;

	private String summary;
	private String exposure;
//	private String category;
//	private List<TagDto> postTagList;
//	private byte[] thumbnail_image;

//	public Post toEntity(User user, Category category) {
	public Post toEntity() {
		return Post.builder()
				.user(this.user)
				.title(this.title)
				.content(this.content)
				.summary(this.summary)
//				.category(category)
				.exposure(Exposure.valueOf(this.exposure))
				.build();
	}

	public void setUser(User user) {
		this.user = user;
	}

}
