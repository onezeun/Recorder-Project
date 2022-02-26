package com.record.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.record.backend.domain.user.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);

	Optional<User> findByDomain(String domain);

	boolean existsByDomain(String domain);
}
