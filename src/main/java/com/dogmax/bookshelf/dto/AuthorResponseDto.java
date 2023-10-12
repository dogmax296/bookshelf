package com.dogmax.bookshelf.dto;

import lombok.Data;

@Data
public class AuthorResponseDto {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
}
