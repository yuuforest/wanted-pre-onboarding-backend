package com.wanted.onboarding.domain.board.service;

import com.wanted.onboarding.domain.board.dto.request.BoardRequestDto;
import com.wanted.onboarding.domain.board.dto.response.ListBoardResponseDto;
import com.wanted.onboarding.domain.board.dto.response.SingleBoardResponseDto;
import com.wanted.onboarding.domain.board.entity.Board;
import com.wanted.onboarding.domain.board.repository.BoardRepository;
import com.wanted.onboarding.domain.member.entity.Member;
import com.wanted.onboarding.domain.member.service.MemberService;
import com.wanted.onboarding.error.code.BoardErrorCode;
import com.wanted.onboarding.error.exception.ErrorException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final MemberService memberService;

    @Override
    public void registerBoard(Authentication authentication, BoardRequestDto request) {
        Member member = memberService.getMember(authentication.getName());

        Board board = Board.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .member(member)
                .build();

        boardRepository.save(board);
    }

    @Override
    public List<ListBoardResponseDto> getBoards(Pageable pageable) {
        Page<Board> pageBoard = boardRepository.findAll(pageable);
        return pageBoard.stream()
                .map(m -> new ListBoardResponseDto(m.getTitle(), m.getCreateDate()))
                .collect(Collectors.toList());
    }

    @Override
    public SingleBoardResponseDto getBoard(Authentication authentication, long boardSeq) {
        memberService.getMember(authentication.getName());

        Board board = getBoard(boardSeq);

        return SingleBoardResponseDto.builder()
                .title(board.getTitle())
                .content(board.getContent())
                .createDate(board.getCreateDate())
                .modifyDate(board.getModifyDate())
                .writer(board.getMember().getId())
                .build();
    }

    @Override
    @Transactional
    public void modifyBoard(Authentication authentication, long boardSeq, BoardRequestDto request) {
        Member member = memberService.getMember(authentication.getName());
        Board board = getBoard(boardSeq);

        // 작성자와 로그인 사용자가 동일해야 함
        if(!Objects.equals(board.getMember().getId(), member.getId()))
            throw new ErrorException(BoardErrorCode.BOARD_WRITER_DIFFERENT);

        String title = request.getTitle();
        String content = request.getContent();

        if(StringUtils.hasText(title)) board.setTitle(title);
        if(StringUtils.hasText(content)) board.setContent(content);
    }

    @Override
    public void removeBoard(Authentication authentication, long boardSeq) {
        Member member = memberService.getMember(authentication.getName());
        Board board = getBoard(boardSeq);

        // 작성자와 로그인 사용자가 동일해야 함
        if(!Objects.equals(board.getMember().getId(), member.getId()))
            throw new ErrorException(BoardErrorCode.BOARD_WRITER_DIFFERENT);

        boardRepository.delete(board);
    }

    @Override
    public Board getBoard(long boardSeq) {
        return boardRepository.findById(boardSeq).orElseThrow(() -> new ErrorException(BoardErrorCode.BOARD_NOT_CORRECT));
    }

}
