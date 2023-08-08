package com.wanted.onboarding.error.code;

import org.springframework.http.HttpStatus;

public interface ErrorCode {

    String name();
    String getCode();
    String getMessage();
    HttpStatus getHttpStatus();
}
