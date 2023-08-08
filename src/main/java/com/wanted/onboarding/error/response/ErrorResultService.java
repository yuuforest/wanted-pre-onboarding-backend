package com.wanted.onboarding.error.response;

import com.wanted.onboarding.error.code.ErrorCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ErrorResultService {

    private ErrorResult setErrorResponse(final ErrorCode errorCode) {
        return ErrorResult.builder()
                .success(false)
                .code(errorCode.getCode())
                .error(errorCode.name())
                .message(errorCode.getMessage())
                .build();
    }

    public ResponseEntity<Object> handleExceptionInternal(final ErrorCode errorCode) {
        return ResponseEntity.status(errorCode.getHttpStatus())
                .body(setErrorResponse(errorCode));
    }
}
