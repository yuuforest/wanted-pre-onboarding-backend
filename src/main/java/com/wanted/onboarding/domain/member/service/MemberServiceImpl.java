package com.wanted.onboarding.domain.member.service;

import com.wanted.onboarding.domain.member.dto.request.RegisterRequestDto;
import com.wanted.onboarding.domain.member.entity.Member;
import com.wanted.onboarding.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public void register(RegisterRequestDto requestDto) {

        String email = requestDto.getEmail();
        String password = requestDto.getPassword();

        Member member = Member.builder()
                .id(email)
                .password(password)
                .build();

        memberRepository.save(member);
    }
}
