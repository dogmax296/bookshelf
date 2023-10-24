package com.dogmax.bookshelf.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemRequestDto {
    private Long bookID;
    private BigDecimal quantity;
}
