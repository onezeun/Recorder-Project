package com.record.backend.repository.dto;

import com.record.backend.domain.comment.Comment;
import com.record.backend.domain.post.Exposure;
import com.record.backend.domain.post.Post;
import com.record.backend.domain.post.PostLike;
import com.record.backend.domain.post.PostTag;
import com.record.backend.domain.user.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class PostUpdateDto {

    private Long post_id;
    private String title;
    private String content;
    private String summary;
    private byte[] thumbnail_image;
    private Exposure exposure;
    private List<PostTag> postTagList;

    @Builder
    public PostUpdateDto(Long post_id, String title, String content,
                         String summary, byte[] thumbnail_image,
                         Exposure exposure, List<PostTag> postTagList) {
        this.post_id = post_id;
        this.title = title;
        this.content = content;
        this.summary = summary;
        this.thumbnail_image = thumbnail_image;
        this.exposure = exposure;
        this.postTagList = postTagList;
    }
}
