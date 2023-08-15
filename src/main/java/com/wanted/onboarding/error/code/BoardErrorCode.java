package com.wanted.onboarding.error.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum BoardErrorCode implements ErrorCode {

    BOARD_NOT_CORRECT("400", "해당하는 게시글이 존재하지 않습니다.", HttpStatus.BAD_REQUEST),
    BOARD_WRITER_DIFFERENT("400", "로그인 사용자는 해당 글의 작성자가 아닙니다.", HttpStatus.BAD_REQUEST);

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;
}
