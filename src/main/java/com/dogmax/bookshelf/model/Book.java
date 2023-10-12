package com.dogmax.bookshelf.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;


@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(name = "authors_books",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Author> authors;
    private String isbn;
    @ManyToMany
    @JoinTable(name = "genres_books",
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Genre> genres;
    private Integer publicationYear;
    private String description;
    private BigDecimal price;
    private Availability availability;
    private String coverImageLink;
    private Language language;
    @ManyToMany
    @JoinTable(name = "formats_books",
            joinColumns = @JoinColumn(name = "format_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Format> formats;
}
