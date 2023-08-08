package com.wanted.onboarding.error.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorResult {

    private final boolean success;
    private final String code;
    private final String error;
    private final String message;
}
