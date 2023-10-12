package com.dogmax.bookshelf.dto;

import lombok.Data;

@Data
public class AuthorRequestDto {
    private String firstName;
    private String middleName;
    private String lastName;
}
