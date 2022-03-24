package com.record.backend.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.record.backend.auth.domain.RefreshToken;
import com.record.backend.domain.user.User;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

	@Override
	Optional<RefreshToken> findById(Long id);
	Optional<RefreshToken> findByToken(String token);

	int deleteByUser(User user);
}
