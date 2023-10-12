package com.dogmax.bookshelf.service.mapper.impl;

import com.dogmax.bookshelf.dto.GenreRequestDto;
import com.dogmax.bookshelf.dto.GenreResponseDto;
import com.dogmax.bookshelf.model.Genre;
import com.dogmax.bookshelf.service.mapper.DtoMapper;

public class GenreDtoMapper implements DtoMapper<Genre, GenreRequestDto, GenreResponseDto> {
    @Override
    public Genre mapToModel(GenreRequestDto genreRequestDto) {
        Genre genre =new Genre();
        genre.setGenre(genreRequestDto.getGenre());
        return genre;
    }

    @Override
    public GenreResponseDto mapToDto(Genre genre) {
        GenreResponseDto genreResponseDto = new GenreResponseDto();
        genreResponseDto.setId(genre.getId());
        genreResponseDto.setGenre(genre.getGenre());
        return genreResponseDto;
    }
}
