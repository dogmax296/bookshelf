package com.dogmax.bookshelf.dto;

import lombok.Data;

@Data
public class UserRequestDto {
    private String login;
    private String password;
}
