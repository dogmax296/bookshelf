package com.dogmax.bookshelf.service.mapper.impl;

import com.dogmax.bookshelf.dto.AuthorRequestDto;
import com.dogmax.bookshelf.dto.AuthorResponseDto;
import com.dogmax.bookshelf.dto.AvailabilityRequestDto;
import com.dogmax.bookshelf.dto.AvailabilityResponseDto;
import com.dogmax.bookshelf.dto.BookRequestDto;
import com.dogmax.bookshelf.dto.BookResponseDto;
import com.dogmax.bookshelf.dto.FormatRequestDto;
import com.dogmax.bookshelf.dto.FormatResponseDto;
import com.dogmax.bookshelf.dto.GenreRequestDto;
import com.dogmax.bookshelf.dto.GenreResponseDto;
import com.dogmax.bookshelf.dto.LanguageRequestDto;
import com.dogmax.bookshelf.dto.LanguageResponseDto;
import com.dogmax.bookshelf.model.Author;
import com.dogmax.bookshelf.model.Availability;
import com.dogmax.bookshelf.model.Book;
import com.dogmax.bookshelf.model.Format;
import com.dogmax.bookshelf.model.Genre;
import com.dogmax.bookshelf.model.Language;
import com.dogmax.bookshelf.service.mapper.DtoMapper;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
@Service
public class BookDtoMapper implements DtoMapper<Book, BookRequestDto, BookResponseDto> {

    private final DtoMapper<Author, AuthorRequestDto, AuthorResponseDto> authorDtoMapper;
    private final DtoMapper<Genre, GenreRequestDto, GenreResponseDto> genreDtoMapper;
    private final DtoMapper<Availability, AvailabilityRequestDto, AvailabilityResponseDto> availabilityDtoMapper;
    private final DtoMapper<Language, LanguageRequestDto, LanguageResponseDto> languageDtoMapper;
    private final DtoMapper<Format, FormatRequestDto, FormatResponseDto> formatDtoMapper;

    public BookDtoMapper(DtoMapper<Author, AuthorRequestDto,AuthorResponseDto> authorDtoMapper,
                         DtoMapper<Genre, GenreRequestDto, GenreResponseDto> genreDtoMapper,
                         DtoMapper<Availability, AvailabilityRequestDto, AvailabilityResponseDto> availabilityDtoMapper,
                         DtoMapper<Language, LanguageRequestDto, LanguageResponseDto> languageDtoMapper,
                         DtoMapper<Format, FormatRequestDto, FormatResponseDto> formatDtoMapper) {
        this.authorDtoMapper = authorDtoMapper;
        this.genreDtoMapper = genreDtoMapper;
        this.availabilityDtoMapper = availabilityDtoMapper;
        this.languageDtoMapper = languageDtoMapper;
        this.formatDtoMapper = formatDtoMapper;
    }

    @Override
    public Book mapToModel(BookRequestDto bookRequestDto) {
        Book book = new Book();
        book.setName(bookRequestDto.getName());
        book.setAuthors(
                bookRequestDto.getAuthors()
                        .stream()
                        .map(authorDtoMapper::mapToModel)
                        .collect(Collectors.toSet())
        );
        book.setIsbn(bookRequestDto.getIsbn());
        book.setGenres(
                bookRequestDto.getGenres()
                        .stream()
                        .map(genreDtoMapper::mapToModel)
                        .collect(Collectors.toSet())
        );
        book.setPublicationYear(bookRequestDto.getPublicationYear());
        book.setDescription(bookRequestDto.getDescription());
        book.setPrice(bookRequestDto.getPrice());
        book.setAvailability(availabilityDtoMapper.mapToModel(bookRequestDto.getAvailability()));
        book.setCoverImageLink(bookRequestDto.getCoverImageLink());
        book.setLanguage(languageDtoMapper.mapToModel(bookRequestDto.getLanguage()));
        book.setFormats(
                bookRequestDto.getFormats()
                        .stream()
                        .map(formatDtoMapper::mapToModel)
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
        bookResponseDto.setAvailability(availabilityDtoMapper.mapToDto(book.getAvailability()));
        bookResponseDto.setCoverImageLink(book.getCoverImageLink());
        bookResponseDto.setLanguage(languageDtoMapper.mapToDto(book.getLanguage()));
        bookResponseDto.setFormats(
                book.getFormats()
                        .stream()
                        .map(formatDtoMapper::mapToDto)
                        .collect(Collectors.toList())

        );
        return bookResponseDto;
    }
}
