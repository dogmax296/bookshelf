package com.dogmax.bookshelf.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserResponseDto {
    private Long id;
    private String login;
    private List<RoleResponseDto> roles;
    private List<Long> orderIDS;
    private String status;
}
