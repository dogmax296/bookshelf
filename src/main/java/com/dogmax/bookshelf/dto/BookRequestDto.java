package com.dogmax.bookshelf.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Data
public class BookRequestDto {
    private String name;
    private List<AuthorRequestDto> authors;
    private String isbn;
    private List<String> genres;
    private Integer publicationYear;
    private String description;
    private BigDecimal price;
    private Integer availability;
    private String coverImageLink;
    private String language;
    private List<String> formats;
}
