package com.dogmax.bookshelf.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class BookRequestDto {
    private String name;
    private List<AuthorRequestDto> authors;
    private String isbn;
    private List<GenreRequestDto> genres;
    private Integer publicationYear;
    private String description;
    private BigDecimal price;
    private BigDecimal quantity;
    private String coverImageLink;
    private LanguageRequestDto language;
    private List<FormatRequestDto> formats;
}
