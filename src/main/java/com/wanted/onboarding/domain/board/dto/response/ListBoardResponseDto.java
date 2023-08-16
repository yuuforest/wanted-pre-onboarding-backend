package com.wanted.onboarding.domain.board.dto.response;


import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ListBoardResponseDto {

    private final long boardSeq;
    private final String title;
    private final LocalDateTime createDate;

    public ListBoardResponseDto(long boardSeq, String title, LocalDateTime createDate) {
        this.boardSeq = boardSeq;
        this.title = title;
        this.createDate = createDate;
    }
}
