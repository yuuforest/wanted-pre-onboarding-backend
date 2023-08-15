package com.wanted.onboarding.domain.board.service;

import com.wanted.onboarding.domain.board.dto.request.BoardRequestDto;
import com.wanted.onboarding.domain.board.dto.response.ListBoardResponseDto;
import com.wanted.onboarding.domain.board.dto.response.SingleBoardResponseDto;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface BoardService {

    void registerBoard(BoardRequestDto request, Authentication authentication);

    List<ListBoardResponseDto> getBoards();

    SingleBoardResponseDto getBoard(long boardSeq);

    void modifyBoard(long boardSeq, BoardRequestDto request);

    void removeBoard(long boardSeq);


}
