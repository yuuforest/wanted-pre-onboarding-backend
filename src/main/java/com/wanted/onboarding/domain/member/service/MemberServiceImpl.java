package com.wanted.onboarding.domain.member.service;

import com.wanted.onboarding.domain.member.dto.request.MemberRequestDto;
import com.wanted.onboarding.domain.member.dto.response.LoginResponseDto;
import com.wanted.onboarding.domain.member.entity.Member;
import com.wanted.onboarding.domain.member.repository.MemberRepository;
import com.wanted.onboarding.error.code.MemberErrorCode;
import com.wanted.onboarding.error.exception.ErrorException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(MemberRequestDto requestDto) {

        String email = requestDto.getEmail();
        String password = requestDto.getPassword();

        // 아이디 및 비밀번호 유효성 검사
        if (!email.contains("@")) throw new ErrorException(MemberErrorCode.ID_MISSING_SYMBOL);
        if (password.length() < 8) throw new ErrorException(MemberErrorCode.PASSWORD_SHORT_LENGTH);

        Member member = Member.builder()
                .id(email)
                .password(passwordEncoder.encode(password))
                .build();

        memberRepository.save(member);
    }

    @Override
    public LoginResponseDto login(MemberRequestDto requestDto) {

        String email = requestDto.getEmail();
        String password = requestDto.getPassword();

        // 아이디 및 비밀번호 유효성 검사
        if (!email.contains("@")) throw new ErrorException(MemberErrorCode.ID_MISSING_SYMBOL);
        if (password.length() < 8) throw new ErrorException(MemberErrorCode.PASSWORD_SHORT_LENGTH);

        // 사용자 인증
        Member member = memberRepository.findById(email)
                .orElseThrow(() -> new ErrorException(MemberErrorCode.ID_NOT_CORRECT));

        if (!passwordEncoder.matches(password, member.getPassword()))
                    throw new ErrorException(MemberErrorCode.PASSWORD_NOT_CORRECT);

        // 유효성 검사 및 사용자 인증 종료


        return null;
    }
}
