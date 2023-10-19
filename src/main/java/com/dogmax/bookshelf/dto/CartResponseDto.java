package com.dogmax.bookshelf.dto;

import lombok.Data;

import java.util.List;

@Data
public class CartResponseDto {
    private Long id;
    private List<CartItemResponseDto> cartItems;
}
