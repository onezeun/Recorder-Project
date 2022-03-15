package com.record.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.record.backend.repository.MemberRepository;


@EnableJpaAuditing
@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Autowired
	private MemberRepository memberRepository;

	@Override
	public void run(String... args) throws Exception {
		 this.memberRepository.save(new Member("lhj", "abc@naver.com"));
	}
}
