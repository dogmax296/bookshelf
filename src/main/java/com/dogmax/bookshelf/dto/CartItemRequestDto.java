package com.dogmax.bookshelf.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartItemRequestDto {
    private Long bookId;
    private BigDecimal quantity;
}
