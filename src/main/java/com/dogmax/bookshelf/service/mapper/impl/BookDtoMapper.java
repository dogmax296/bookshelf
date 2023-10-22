package com.dogmax.bookshelf.service.mapper.impl;

import com.dogmax.bookshelf.dto.AuthorRequestDto;
import com.dogmax.bookshelf.dto.AuthorResponseDto;
import com.dogmax.bookshelf.dto.BookRequestDto;
import com.dogmax.bookshelf.dto.BookResponseDto;
import com.dogmax.bookshelf.dto.FormatRequestDto;
import com.dogmax.bookshelf.dto.FormatResponseDto;
import com.dogmax.bookshelf.dto.GenreRequestDto;
import com.dogmax.bookshelf.dto.GenreResponseDto;
import com.dogmax.bookshelf.dto.LanguageRequestDto;
import com.dogmax.bookshelf.dto.LanguageResponseDto;
import com.dogmax.bookshelf.model.Author;
import com.dogmax.bookshelf.model.Book;
import com.dogmax.bookshelf.model.Format;
import com.dogmax.bookshelf.model.Genre;
import com.dogmax.bookshelf.model.Language;
import com.dogmax.bookshelf.service.AuthorService;
import com.dogmax.bookshelf.service.FormatService;
import com.dogmax.bookshelf.service.GenreService;
import com.dogmax.bookshelf.service.LanguageService;
import com.dogmax.bookshelf.service.mapper.DtoMapper;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class BookDtoMapper implements DtoMapper<Book, BookRequestDto, BookResponseDto> {

    private final DtoMapper<Author, AuthorRequestDto, AuthorResponseDto> authorDtoMapper;
    private final DtoMapper<Genre, GenreRequestDto, GenreResponseDto> genreDtoMapper;
    private final DtoMapper<Language, LanguageRequestDto, LanguageResponseDto> languageDtoMapper;
    private final DtoMapper<Format, FormatRequestDto, FormatResponseDto> formatDtoMapper;
    private final AuthorService authorService;
    private final GenreService genreService;
    private final FormatService formatService;
    private final LanguageService languageService;

    public BookDtoMapper(DtoMapper<Author, AuthorRequestDto, AuthorResponseDto> authorDtoMapper,
                         DtoMapper<Genre, GenreRequestDto, GenreResponseDto> genreDtoMapper,
                         DtoMapper<Language, LanguageRequestDto, LanguageResponseDto> languageDtoMapper,
                         DtoMapper<Format, FormatRequestDto, FormatResponseDto> formatDtoMapper,
                         AuthorService authorService,
                         GenreService genreService,
                         FormatService formatService,
                         LanguageService languageService) {
        this.authorDtoMapper = authorDtoMapper;
        this.genreDtoMapper = genreDtoMapper;
        this.languageDtoMapper = languageDtoMapper;
        this.formatDtoMapper = formatDtoMapper;
        this.authorService = authorService;
        this.genreService = genreService;
        this.formatService = formatService;
        this.languageService = languageService;
    }

    @Override
    public Book mapToModel(BookRequestDto bookRequestDto) {
        Book book = new Book();
        book.setName(bookRequestDto.getName());
        book.setAuthors(
                bookRequestDto.getAuthorsID()
                        .stream()
                        .map(authorService::getById)
                        .collect(Collectors.toSet())
        );
        book.setIsbn(bookRequestDto.getIsbn());
        book.setGenres(
                bookRequestDto.getGenresID()
                        .stream()
                        .map(genreService::getById)
                        .collect(Collectors.toSet())
        );
        book.setPublicationYear(bookRequestDto.getPublicationYear());
        book.setDescription(bookRequestDto.getDescription());
        book.setPrice(bookRequestDto.getPrice());
        book.setQuantity(bookRequestDto.getQuantity());
        book.setCoverImageLink(bookRequestDto.getCoverImageLink());
        book.setLanguages(bookRequestDto.getLanguagesID()
                .stream()
                .map(languageService::getById)
                .collect(Collectors.toSet())
        );
        book.setFormats(
                bookRequestDto.getFormatsID()
                        .stream()
                        .map(formatService::getById)
                        .collect(Collectors.toSet())

        );

        return book;
    }

    @Override
    public BookResponseDto mapToDto(Book book) {
        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setId(book.getId());
        bookResponseDto.setName(book.getName());
        bookResponseDto.setAuthors(
                book.getAuthors()
                        .stream()
                        .map(authorDtoMapper::mapToDto)
                        .collect(Collectors.toList())
        );
        bookResponseDto.setIsbn(book.getIsbn());
        bookResponseDto.setGenres(
                book.getGenres()
                        .stream()
                        .map(genreDtoMapper::mapToDto)
                        .collect(Collectors.toList())
        );
        bookResponseDto.setPublicationYear(book.getPublicationYear());
        bookResponseDto.setDescription(book.getDescription());
        bookResponseDto.setPrice(book.getPrice());
        bookResponseDto.setQuantity(book.getQuantity());
        bookResponseDto.setCoverImageLink(book.getCoverImageLink());
        bookResponseDto.setLanguage(book.getLanguages()
                .stream()
                .map(languageDtoMapper::mapToDto)
                .collect(Collectors.toList())
        );
        bookResponseDto.setFormats(
                book.getFormats()
                        .stream()
                        .map(formatDtoMapper::mapToDto)
                        .collect(Collectors.toList())

        );
        return bookResponseDto;
    }
}
