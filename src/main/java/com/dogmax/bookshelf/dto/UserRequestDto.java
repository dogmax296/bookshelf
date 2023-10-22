package com.dogmax.bookshelf.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserRequestDto {
    private String login;
    private String password;
    private List<Long> rolesID;
}
