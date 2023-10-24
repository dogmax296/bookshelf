package com.dogmax.bookshelf.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderResponseDto {
    private Long id;
    private List<OrderItemResponseDto> orderItems;
    private String status;
}
