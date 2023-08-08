package com.wanted.onboarding.error.exception;

import com.wanted.onboarding.error.code.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ErrorException extends RuntimeException {
    private final ErrorCode errorCode;
}
