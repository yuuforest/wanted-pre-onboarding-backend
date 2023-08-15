package com.wanted.onboarding.domain.board.service;

import com.wanted.onboarding.domain.board.dto.request.BoardRequestDto;
import com.wanted.onboarding.domain.board.dto.response.ListBoardResponseDto;
import com.wanted.onboarding.domain.board.dto.response.SingleBoardResponseDto;
import com.wanted.onboarding.domain.board.entity.Board;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface BoardService {

    void registerBoard(Authentication authentication, BoardRequestDto request);

    List<ListBoardResponseDto> getBoards();

    SingleBoardResponseDto getBoard(Authentication authentication, long boardSeq);

    void modifyBoard(Authentication authentication, long boardSeq, BoardRequestDto request);

    void removeBoard(long boardSeq);

    Board getBoard(long boardSeq);
}
