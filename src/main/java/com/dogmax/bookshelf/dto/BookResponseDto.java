package com.dogmax.bookshelf.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class BookResponseDto {
    private Long id;
    private List<AuthorResponseDto> authors;
    private String isbn;
    private List<String> genres;
    private Integer publicationYear;
    private String description;
    private BigDecimal price;
    private String availability;
    private String coverImageLink;
    private String language;
    private List<String> formats;
}
