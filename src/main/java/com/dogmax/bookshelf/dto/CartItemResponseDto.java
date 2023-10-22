package com.dogmax.bookshelf.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartItemResponseDto {
    private Long id;
    private Long bookId;
    private BigDecimal quantity;

}