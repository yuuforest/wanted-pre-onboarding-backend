package com.wanted.onboarding.domain.member.service;

import com.wanted.onboarding.domain.member.dto.request.MemberRequestDto;
import com.wanted.onboarding.domain.member.dto.request.TokenRequestDto;
import com.wanted.onboarding.domain.member.dto.response.LoginResponseDto;
import com.wanted.onboarding.domain.member.dto.response.TokenResponseDto;
import com.wanted.onboarding.domain.member.entity.Member;

public interface MemberService {

    void register(MemberRequestDto requestDto);
    LoginResponseDto login(MemberRequestDto requestDto);
    TokenResponseDto reissueToken(TokenRequestDto requestDto);
    Member getMember(String email);
}
