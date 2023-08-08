package com.wanted.onboarding.error.handler;

import com.wanted.onboarding.error.code.ErrorCode;
import com.wanted.onboarding.error.exception.ErrorException;
import com.wanted.onboarding.error.response.ErrorResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class ErrorExceptionHandler {

    private final ErrorResultService resultService;

    @ExceptionHandler(ErrorException.class)
    public ResponseEntity<Object> handleCustomException(final ErrorException error) {
        final ErrorCode errorCode = error.getErrorCode();
        return resultService.handleExceptionInternal(errorCode);
    }
}
