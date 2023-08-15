package com.wanted.onboarding.config.jwt;

import com.wanted.onboarding.error.code.TokenErrorCode;
import com.wanted.onboarding.error.exception.ErrorException;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtTokenProvider {

    @Value("${jwt.header}")
    private String AUTHORIZATION_HEADER;

    @Value("${jwt.secret}")
    private String secretKey;

    private final UserDetailsService userDetailsService;

    private final Long ACCESS_TOKEN_EXPIRE_TIME = 30 * 60 * 1000L;                  // 30분
    private final Long REFRESH_TOKEN_EXPIRE_TIME = 60 * 60 * 24 * 7 * 1000L;        // 일주일

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    // JWT 토큰 생성 - AccessToken
    public String generateAccessToken(String id) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + ACCESS_TOKEN_EXPIRE_TIME);

        Claims claims = Jwts.claims().setSubject(id);

        return Jwts.builder()
                .setHeaderParam("type", "AccessToken")
                .setClaims(claims)              // 데이터 (JWT의 Body)
                .setIssuedAt(now)               // 토큰 발행 일자
                .setExpiration(expiration)      // 만료 기간
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    // JWT 토큰 생성 - RefreshToken
    public String generateRefreshToken(String id) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + REFRESH_TOKEN_EXPIRE_TIME);

        Claims claims = Jwts.claims().setSubject(id);

        return Jwts.builder()
                .setHeaderParam("type", "RefreshToken")
                .setClaims(claims)              // 데이터 (JWT의 Body)
                .setIssuedAt(now)               // 토큰 발행 일자
                .setExpiration(expiration)      // 만료 기간
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    // JWT 토큰으로 인증 정보 조회
    public Authentication getAuthentication(String token) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUserId(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    // JWT 토큰에서 User ID 추출
    public String getUserId(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    // HTTP 헤더에서 JWT 토큰 추출
    public String resolveToken(HttpServletRequest request) {
        return request.getHeader(AUTHORIZATION_HEADER);
    }

    // JWT 토큰의 유효성 및 만료 기간 검사
    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (Exception e) {
            throw new ErrorException(TokenErrorCode.TOKEN_ERROR);
        }
    }

}
