package com.dogmax.bookshelf.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class BookRequestDto {
    private String name;
    private Set<Long> authorsID;
    private String isbn;
    private Set<Long> genresID;
    private Integer publicationYear;
    private String description;
    private BigDecimal price;
    private BigDecimal quantity;
    private String coverImageLink;
    private Set<Long> languagesID;
    private Set<Long> formatsID;
}
