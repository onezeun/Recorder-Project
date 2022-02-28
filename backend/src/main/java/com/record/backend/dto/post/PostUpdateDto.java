package com.record.backend.dto.post;

import com.record.backend.domain.comment.Comment;
import com.record.backend.domain.post.Exposure;
import com.record.backend.domain.post.Post;
import com.record.backend.domain.post.PostLike;
import com.record.backend.domain.post.PostTag;
import com.record.backend.domain.user.User;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostUpdateDto {

    private String title;
    private String content;
    private String summary;
    private String exposure;
//    private List<PostTag> postTagList;
//    private byte[] thumbnail_image;

}
