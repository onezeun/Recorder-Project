package com.record.backend.repository.user;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.record.backend.domain.user.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);

	Optional<User> findByDomain(String domain);

	@Query("select t from Follow f inner join f.target t on f.source = :user")
	List<User> searchFollowingsOf(@Param("user") User user, Pageable pageable);

	@Query("select s from Follow f inner join f.source s on f.target = :user")
	List<User> searchFollowersOf(@Param("user") User user, Pageable pageable);
}
