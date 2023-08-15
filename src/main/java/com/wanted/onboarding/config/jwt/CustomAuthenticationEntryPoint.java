package com.wanted.onboarding.config.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanted.onboarding.error.code.ErrorCode;
import com.wanted.onboarding.error.code.TokenErrorCode;
import com.wanted.onboarding.error.response.ErrorResult;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        setResponse(response, TokenErrorCode.TOKEN_ERROR);
    }

    private void setResponse(HttpServletResponse response, ErrorCode errorCode) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(errorCode.getHttpStatus().value());

        ErrorResult result = ErrorResult.builder()
                .success(false)
                .code(errorCode.getCode())
                .error(errorCode.name())
                .message(errorCode.getMessage())
                .build();

        // 한글 출력을 위해 getWriter() 사용
        response.getWriter().write(objectMapper.writeValueAsString(result));
    }
}
