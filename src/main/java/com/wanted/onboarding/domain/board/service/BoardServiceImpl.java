package com.wanted.onboarding.domain.board.service;

import com.wanted.onboarding.domain.board.dto.request.BoardRequestDto;
import com.wanted.onboarding.domain.board.dto.response.ListBoardResponseDto;
import com.wanted.onboarding.domain.board.dto.response.SingleBoardResponseDto;
import com.wanted.onboarding.domain.board.entity.Board;
import com.wanted.onboarding.domain.board.repository.BoardRepository;
import com.wanted.onboarding.domain.member.entity.Member;
import com.wanted.onboarding.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    private final MemberService memberService;

    @Override
    public void registerBoard(BoardRequestDto request, Authentication authentication) {
        Member member = memberService.getMember(authentication.getName());

        Board board = Board.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .member(member)
                .build();

        boardRepository.save(board);
    }

    @Override
    public List<ListBoardResponseDto> getBoards() {
        return null;
    }

    @Override
    public SingleBoardResponseDto getBoard(long boardSeq) {
        return null;
    }

    @Override
    public void modifyBoard(long boardSeq, BoardRequestDto request) {

    }

    @Override
    public void removeBoard(long boardSeq) {

    }
}
