package com.dogmax.bookshelf.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderResponseDto {
    private Long id;
    private List<CartItemResponseDto> cartItems;
    private String status;
}
