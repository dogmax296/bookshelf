package com.dogmax.bookshelf.service.mapper.impl;

import com.dogmax.bookshelf.dto.AuthorRequestDto;
import com.dogmax.bookshelf.dto.AuthorResponseDto;
import com.dogmax.bookshelf.model.Author;
import com.dogmax.bookshelf.service.mapper.DtoMapper;
import org.springframework.stereotype.Service;

@Service
public class AuthorDtoMapper implements DtoMapper<Author, AuthorRequestDto, AuthorResponseDto> {
    @Override
    public Author mapToModel(AuthorRequestDto authorRequestDto) {
        Author author = new Author();
        author.setFirstName(authorRequestDto.getFirstName());
        author.setMiddleName(authorRequestDto.getMiddleName());
        author.setLastName(authorRequestDto.getLastName());
        return author;
    }

    @Override
    public AuthorResponseDto mapToDto(Author author) {
        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        authorResponseDto.setId(author.getId());
        authorResponseDto.setFirstName(author.getFirstName());
        authorResponseDto.setMiddleName(author.getMiddleName());
        authorResponseDto.setLastName(author.getLastName());
        return authorResponseDto;
    }
}
