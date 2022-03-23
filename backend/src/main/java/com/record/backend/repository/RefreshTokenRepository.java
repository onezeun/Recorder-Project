package com.record.backend.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.record.backend.auth.domain.RefreshToken;
import com.record.backend.domain.user.User;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

	@Override
	Optional<RefreshToken> findById(Long id);
	Optional<RefreshToken> findByToken(String token);

	@Query("SELECT r.user.id FROM refreshtoken r where r.token = :token ")
	long findByUserForToken(@Param("token") String token);

	int deleteByUser(User user);
}
