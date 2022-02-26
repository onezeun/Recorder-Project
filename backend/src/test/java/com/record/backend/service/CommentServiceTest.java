package com.record.backend.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.record.backend.repository.comment.CommentRepository;
import com.record.backend.repository.post.PostRepository;
import com.record.backend.repository.user.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CommentServiceTest {

	@Autowired UserRepository userRepository;
	@Autowired PostRepository postRepository;
	@Autowired CommentRepository commentRepository;

	@Test
	public void 댓글_작성_테스트() {
		//given

		//when

		//then
	}

	@Test
	public void 댓글_수정_테스트() {
		//given

		//when

		//then
	}

	@Test
	public void 댓글_삭제_테스트() {
		//given

		//when

		//then
	}
}