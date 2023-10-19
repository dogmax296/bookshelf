package com.dogmax.bookshelf.dto;

import lombok.Data;

import java.util.List;

@Data
public class CartRequestDto {
    private List<CartItemRequestDto> cartItems;
}
