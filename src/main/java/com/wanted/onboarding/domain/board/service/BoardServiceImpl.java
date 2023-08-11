package com.wanted.onboarding.domain.board.service;

import com.wanted.onboarding.domain.board.dto.request.BoardRequestDto;
import com.wanted.onboarding.domain.board.dto.response.ListBoardResponseDto;
import com.wanted.onboarding.domain.board.dto.response.SingleBoardResponseDto;
import com.wanted.onboarding.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public void registerBoard(BoardRequestDto request) {

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
