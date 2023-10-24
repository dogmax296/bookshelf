package com.dogmax.bookshelf.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemResponseDto {
    private Long id;
    private Long bookID;
    private BigDecimal quantity;
    private BigDecimal sum;
}
