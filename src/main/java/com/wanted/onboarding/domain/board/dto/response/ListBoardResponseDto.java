package com.wanted.onboarding.domain.board.dto.response;


import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ListBoardResponseDto {

    private String title;
    private LocalDateTime createDate;

}
