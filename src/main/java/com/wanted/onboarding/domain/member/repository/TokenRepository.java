package com.wanted.onboarding.domain.member.repository;

import com.wanted.onboarding.domain.member.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
}
