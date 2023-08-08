package com.wanted.onboarding.domain.member.controller;

import com.wanted.onboarding.common.response.Result;
import com.wanted.onboarding.common.response.ResultService;
import com.wanted.onboarding.domain.member.dto.request.MemberRequestDto;
import com.wanted.onboarding.domain.member.dto.response.LoginResponseDto;
import com.wanted.onboarding.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final ResultService resultService;
    private final MemberService memberService;

    @PostMapping("")
    public ResponseEntity<Result> register(@RequestBody MemberRequestDto requestDto) {
        memberService.register(requestDto);
        return ResponseEntity.ok().body(resultService.getSuccessResponse());
    }

    @PostMapping("/login")
    public ResponseEntity<Result> login(@RequestBody MemberRequestDto requestDto) {
        LoginResponseDto responseDto = memberService.login(requestDto);
        return ResponseEntity.ok().body(resultService.getSingleData(responseDto));
    }
}
