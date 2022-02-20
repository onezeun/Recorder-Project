//package com.record.backend.repository;
//
//import static org.assertj.core.api.Assertions.*;
//
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.record.backend.domain.post.Post;
//import com.record.backend.domain.user.User;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Transactional
//public class PostRepositoryTest {
//
//	@Autowired
//	PostRepository postRepository;
//	@Autowired UserRepository userRepository;
//
///*	@Test
//	//@Rollback(value = false)
//	public void 유저_임시생성() {
//		User user = User.createUser("abc@naver.com", "111");
//		userRepository.save(user);
//	}*/
//
//	@Test
//	@Rollback(value = false)
//	public void 게시글등록_불러오기테스트() {
//		//given
//		String title = "테스트 게시글";
//		String content = "테스트 본문";
//		int hits = 1;
//		String summary = "테스트 요약";
//		String exposure = "1";
//		String content_url = "www.hello";
//
//		User user = new User();
//
//		postRepository.save(Post.builder()
//			.user(user)
//			.title(title)
//			.content(content)
//			.hits(hits)
//			.summary(summary)
//			.exposure(exposure)
//			.content_url(content_url)
//			.build());
//
//		//when
//		List<Post> postList = postRepository.findAll();
//
//		//then
//		Post post = postList.get(0);
//		assertThat(post.getTitle()).isEqualTo(title);
//		assertThat(post.getContent()).isEqualTo(content);
//		assertThat(post.getUser()).isEqualTo(user);
//		assertThat(post.getHits()).isEqualTo(hits);
//		assertThat(post.getSummary()).isEqualTo(summary);
//		assertThat(post.getExposure()).isEqualTo(exposure);
//		assertThat(post.getContent_url()).isEqualTo(content_url);
//
//	}
//}