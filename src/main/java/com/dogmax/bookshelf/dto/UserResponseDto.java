package com.dogmax.bookshelf.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserResponseDto {
    private Long id;
    private String login;
    private String password;
    private List<RoleResponseDto> roles;
    private Long cartId;
    private Long wishlistId;
    private List<Long> orderIds;
    private String status;
}
