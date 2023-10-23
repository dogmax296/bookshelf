package com.dogmax.bookshelf.dto;

import lombok.Data;

import java.util.List;

@Data
public class WishlistResponseDto {
    private Long id;
    List<Long> bookIDS;
}
