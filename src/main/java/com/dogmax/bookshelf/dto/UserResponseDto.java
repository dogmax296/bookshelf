package com.dogmax.bookshelf.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserResponseDto {
    private Long id;
    private String login;
    private List<RoleResponseDto> roles;
    private List<Long> orderIds;
    private String status;
}
