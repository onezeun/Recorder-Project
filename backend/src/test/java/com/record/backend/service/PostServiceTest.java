package com.record.backend.service;

import com.record.backend.domain.post.Exposure;
import com.record.backend.domain.post.Post;
import com.record.backend.domain.user.User;
import com.record.backend.repository.PostRepository;
import com.record.backend.dto.post.PostSaveRequestDto;
import com.record.backend.dto.post.PostUpdateDto;
import com.record.backend.repository.UserRepository;
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
    @Autowired
    UserRepository userRepository;

    @Test
    @Rollback(false)
    public void 게시글등록() throws Exception {
        //given
        User user = new User();
        em.persist(user);

        PostSaveRequestDto requestDto = new PostSaveRequestDto();
        requestDto.setUser_id(user.getId());
        requestDto.setTitle("안녕하세요");
        requestDto.setContent("123");
        requestDto.setExposure("ALL");

        //when
        Long postId = postService.savePost(requestDto);
        
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

        PostSaveRequestDto requestDto = new PostSaveRequestDto();
        requestDto.setUser_id(user.getId());
        requestDto.setTitle("안녕하세요");
        requestDto.setContent("123");
        requestDto.setExposure("ALL");

        Long postId = postService.savePost(requestDto);

        PostUpdateDto updateDto = new PostUpdateDto(
                user.getId(), postId, "HELLO",
                "One Two Three", "One", "NEIGHBOR");

        //when
        Long updatePostId = postService.updatePost(updateDto);

        //then
        Post post = postRepository.findById(updatePostId).get();
        assertNotEquals("update_time이 null이 아니어야 한다.", null, post.getUpdate_time());
        assertNotEquals("create_time 과 update_time이 달라야 한다.", post.getCreated_time(), post.getUpdate_time());
    }
}