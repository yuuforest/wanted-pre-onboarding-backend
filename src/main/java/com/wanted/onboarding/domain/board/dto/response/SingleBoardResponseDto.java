package com.wanted.onboarding.domain.board.dto.response;


import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class SingleBoardResponseDto {

    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

}
