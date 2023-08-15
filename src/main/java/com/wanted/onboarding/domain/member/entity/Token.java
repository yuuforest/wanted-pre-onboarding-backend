package com.wanted.onboarding.domain.member.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tokenSeq;

    @Column(nullable = false)
    private String refreshToken;

    @Builder
    public Token(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
