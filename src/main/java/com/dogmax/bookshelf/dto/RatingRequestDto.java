package com.dogmax.bookshelf.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RatingRequestDto {
    private Long bookId;
    private BigDecimal mark;
}
