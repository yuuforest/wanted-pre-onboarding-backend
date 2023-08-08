package com.wanted.onboarding.domain.member.service;

import com.wanted.onboarding.domain.member.dto.request.MemberRequestDto;
import com.wanted.onboarding.domain.member.dto.response.LoginResponseDto;

public interface MemberService {

    void register(MemberRequestDto requestDto);
    LoginResponseDto login(MemberRequestDto requestDto);
}
