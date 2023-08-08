package com.wanted.onboarding.error.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum MemberErrorCode implements ErrorCode {

    ID_MISSING_SYMBOL("400", "이메일에 @가 포함되지 않았습니다.", HttpStatus.BAD_REQUEST),
    PASSWORD_SHORT_LENGTH("400", "비밀번호가 8자 미만입니다.", HttpStatus.BAD_REQUEST);

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;
}
