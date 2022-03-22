package com.record.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.record.backend.domain.jwt.RefreshToken;
import com.record.backend.domain.user.User;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

	@Override
	Optional<RefreshToken> findById(Long id);
	Optional<RefreshToken> findByToken(String token);

	int deleteByUser(User user);
}
