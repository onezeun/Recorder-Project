package com.record.backend.service;

import com.record.backend.domain.post.Exposure;
import com.record.backend.domain.post.Post;
import com.record.backend.domain.user.User;
import com.record.backend.repository.PostRepository;
import com.record.backend.dto.post.PostSaveRequestDto;
import com.record.backend.dto.post.PostUpdateDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PostServiceTest {

    @Autowired
    EntityManager em;
    @Autowired
    PostService postService;
    @Autowired
    PostRepository postRepository;

    @Test
    @Rollback(false)
    public void 게시글등록() throws Exception {
        //given
        User user = new User();
        em.persist(user);

        PostSaveRequestDto requestDto = PostSaveRequestDto.builder()
                .user(user)
                .title("안녕하세요")
                .content("123")
                .summary("1234")
                .exposure(Exposure.ALL)
                .thumbnail_image(null)
                .postTagList(null)
                .build();

        //when
        Long postId = postService.writePost(requestDto);
        
        //then
        Post post = postRepository.findById(postId).get();

        assertEquals("초기 조회수는 0이다", 0, post.getHits());

    }

    @Test
    @Rollback(false)
    public void 게시글수정() throws Exception {
        //given
        User user = new User();
        em.persist(user);

        PostSaveRequestDto requestDto = PostSaveRequestDto.builder()
                .user(user)
                .title("안녕하세요")
                .content("1234")
                .summary("12")
                .exposure(Exposure.ALL)
                .thumbnail_image(null)
                .postTagList(null)
                .build();

        Long postId = postService.writePost(requestDto);

        PostUpdateDto updateDto = PostUpdateDto.builder()
                .post_id(postId)
                .title("안녕하신가")
                .content("4321")
                .summary("43")
                .thumbnail_image(null)
                .exposure(Exposure.NEIGHBOR)
                .postTagList(null)
                .build();

        //when
        Long updatePostId = postService.updatePost(updateDto);

        //then

        Post post = postRepository.findById(updatePostId).get();
        assertNotEquals("update_time이 null이 아니어야 한다.", null, post.getUpdate_time());
        assertNotEquals("create_time 과 update_time이 달라야 한다.", post.getCreated_time(), post.getUpdate_time());
    }
}