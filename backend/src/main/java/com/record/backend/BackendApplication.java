package com.record.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.record.backend.domain.user.User;
import com.record.backend.repository.MemberRepository;
import com.record.backend.repository.user.UserRepository;

@EnableJpaAuditing
@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		 this.memberRepository.save(new Member("lhj", "abc@naver.com"));
		// this.userRepository.save(new User("modsiw@naver.com", "123", "래지", "modsiw.recorder", "안뇽하세요"));
		// this.userRepository.save(new User("onezeun@naver.com", "123", "한징", "onezeun.recorder", "안뇽하세요"));
	}
}
