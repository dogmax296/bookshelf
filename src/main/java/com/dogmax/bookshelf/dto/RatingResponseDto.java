package com.dogmax.bookshelf.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RatingResponseDto {
    private Long id;
    private Long bookID;
    private BigDecimal mark;

}
