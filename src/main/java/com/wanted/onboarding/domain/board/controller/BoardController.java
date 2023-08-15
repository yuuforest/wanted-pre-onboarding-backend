package com.wanted.onboarding.domain.board.controller;

import com.wanted.onboarding.common.response.Result;
import com.wanted.onboarding.common.response.ResultService;
import com.wanted.onboarding.domain.board.dto.request.BoardRequestDto;
import com.wanted.onboarding.domain.board.dto.response.ListBoardResponseDto;
import com.wanted.onboarding.domain.board.dto.response.SingleBoardResponseDto;
import com.wanted.onboarding.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final ResultService resultService;
    private final BoardService boardService;

    @PostMapping("")
    public ResponseEntity<Result> registerBoard(Authentication authentication, @RequestBody BoardRequestDto request) {
        boardService.registerBoard(authentication, request);
        return ResponseEntity.ok().body(resultService.getSuccessResponse());
    }

    @GetMapping("/all")
    public ResponseEntity<Result> getBoards() {
        // 게시글 목록 조회
        List<ListBoardResponseDto> response = boardService.getBoards();
        return ResponseEntity.ok().body(resultService.getListData(response));
    }

    @GetMapping("/{boardSeq}")
    public ResponseEntity<Result> getBoard(Authentication authentication, @PathVariable("boardSeq") long boardSeq) {
        // 특정 게시글 조회
        SingleBoardResponseDto response = boardService.getBoard(authentication, boardSeq);
        return ResponseEntity.ok().body(resultService.getSingleData(response));
    }

    @PatchMapping("/{boardSeq}")
    public ResponseEntity<Result> modifyBoard(Authentication authentication, @PathVariable("boardSeq") long boardSeq,
                                              @RequestBody BoardRequestDto request) {
        // 특정 게시글 수정
        boardService.modifyBoard(authentication, boardSeq, request);
        return ResponseEntity.ok().body(resultService.getSuccessResponse());
    }

    @DeleteMapping("/{boardSeq}")
    public ResponseEntity<Result> removeBoard(Authentication authentication, @PathVariable("boardSeq") long boardSeq) {
        // 특정 게시글 삭제
        boardService.removeBoard(authentication, boardSeq);
        return ResponseEntity.ok().body(resultService.getSuccessResponse());
    }

}
