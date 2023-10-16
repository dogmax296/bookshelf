package com.dogmax.bookshelf.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class BookResponseDto {
    private Long id;
    private String name;
    private List<AuthorResponseDto> authors;
    private String isbn;
    private List<GenreResponseDto> genres;
    private Integer publicationYear;
    private String description;
    private BigDecimal price;
    private BigDecimal quantity;
    private String coverImageLink;
    private LanguageResponseDto language;
    private List<FormatResponseDto> formats;
}
