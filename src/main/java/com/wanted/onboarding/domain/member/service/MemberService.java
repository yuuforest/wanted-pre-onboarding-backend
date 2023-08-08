package com.wanted.onboarding.domain.member.service;

import com.wanted.onboarding.domain.member.dto.request.RegisterRequestDto;

public interface MemberService {

    void register(RegisterRequestDto requestDto);
}
