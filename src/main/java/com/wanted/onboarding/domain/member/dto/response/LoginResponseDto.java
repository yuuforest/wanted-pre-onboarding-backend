package com.wanted.onboarding.domain.member.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDto {

    private String accessToken;
    private String refreshToken;
}
