package com.wanted.onboarding.domain.board.dto.response;


import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ListBoardResponseDto {

    private final String title;
    private final LocalDateTime createDate;

    public ListBoardResponseDto(String title, LocalDateTime createDate) {
        this.title = title;
        this.createDate = createDate;
    }
}
