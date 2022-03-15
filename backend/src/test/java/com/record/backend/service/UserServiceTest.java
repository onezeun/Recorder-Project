//package com.record.backend.service;
//
//import javax.persistence.EntityManager;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.record.backend.domain.user.User;
//import com.record.backend.repository.user.UserRepository;
//import com.record.backend.dto.user.UserSaveRequestDto;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Transactional
//public class UserServiceTest {
//
//	@Autowired
//	UserRepository userRepository;
//	@Autowired UserService userService;
//	@Autowired EntityManager em;
//
//	//saveid
//	private UserSaveRequestDto createUserDto(String email, String password, String nickname
//		, String domain, String introduce) {
//		UserSaveRequestDto requestDto = new UserSaveRequestDto(email, password, nickname, domain, introduce);
//		requestDto.setEmail(email);
//		requestDto.setPassword(password);
//		requestDto.setNickname(nickname);
//		requestDto.setDomain(domain);
//		requestDto.setIntroduce(introduce);
//		return requestDto;
//	}
//
//	//find User
//	private User findUser(Long id) {
//		return userRepository.findById(id)
//			.orElseThrow(IllegalAccessError::new);
//	}
//
//	//find User with domain
//	private User findUserByDomain(String domain) {
//		return userRepository.findByDomain(domain)
//			.orElseThrow(IllegalAccessError::new);
//	}
//
//	//find User with Email
//	private User findUserByEmail(String email) {
//		return userRepository.findByEmail(email)
//			.orElseThrow(IllegalAccessError::new);
//	}
//
//	@Test
//	public void 유저_생성_테스트() {
//		//given
//
//		//when
//
//		//then
//	}
//
//	@Test
//	public void 유저_업데이트_테스트() {
//		//given
//
//		//when
//
//		//then
//	}
//
//	@Test
//	public void 유저_삭제_테스트() {
//		//given
//
//		//when
//
//		//then
//	}
//
//	@Test
//	public void 유저_도메인중복_테스트() {
//		//given
//
//		//when
//
//		//then
//	}
//
//	@Test
//	public void 유저_패스워드_업데이트_테스트() {
//		//given
//
//		//when
//
//		//then
//	}
//
//	@Test
//	public void 유저_검색_이메일_테스트() {
//		//given
//
//		//when
//
//		//then
//	}
//
//	@Test
//	public void 유저_검색_도메인_테스트() {
//		//given
//
//		//when
//
//		//then
//	}
//
//}