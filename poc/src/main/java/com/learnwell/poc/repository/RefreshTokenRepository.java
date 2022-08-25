package com.learnwell.poc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnwell.poc.models.RefreshToken;
import com.learnwell.poc.models.User;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

	@Override
	Optional<RefreshToken> findById(Long id);

	Optional<RefreshToken> findByToken(String token);

	int deleteByUser(User user);
	
}
