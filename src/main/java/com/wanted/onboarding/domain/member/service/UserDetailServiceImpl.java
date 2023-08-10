package com.wanted.onboarding.domain.member.service;

import com.wanted.onboarding.domain.member.repository.MemberRepository;
import com.wanted.onboarding.error.code.MemberErrorCode;
import com.wanted.onboarding.error.exception.ErrorException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return memberRepository.findById(email).orElseThrow(() -> new ErrorException(MemberErrorCode.ID_NOT_CORRECT));
    }
}