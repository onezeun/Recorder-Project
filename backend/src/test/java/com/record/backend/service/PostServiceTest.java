package com.record.backend.service;

import com.record.backend.domain.post.Exposure;
import com.record.backend.domain.post.Post;
import com.record.backend.domain.user.User;
import com.record.backend.repository.PostRepository;
import com.record.backend.repository.dto.PostSaveRequestDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;
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
    public void 게시글수정() throws Exception {
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

        Long postId = postService.writePost(requestDto);

        //when

        //then
    }
}