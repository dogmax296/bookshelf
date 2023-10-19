package com.dogmax.bookshelf.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDto {
    private List<CartItemRequestDto> cartItems;
    private String status;
}
