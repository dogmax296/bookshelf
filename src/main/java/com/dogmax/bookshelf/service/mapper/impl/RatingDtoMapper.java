package com.dogmax.bookshelf.service.mapper.impl;

import com.dogmax.bookshelf.dto.RatingRequestDto;
import com.dogmax.bookshelf.dto.RatingResponseDto;
import com.dogmax.bookshelf.model.Rating;
import com.dogmax.bookshelf.service.BookService;
import com.dogmax.bookshelf.service.mapper.DtoMapper;
import org.springframework.stereotype.Service;

@Service
public class RatingDtoMapper implements DtoMapper<Rating, RatingRequestDto, RatingResponseDto> {
    private final BookService bookService;

    public RatingDtoMapper(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public Rating mapToModel(RatingRequestDto ratingRequestDto) {
        Rating rating = new Rating();
        rating.setBook(bookService.getById(ratingRequestDto.getBookID()));
        rating.setMark(ratingRequestDto.getMark());
        return rating;
    }

    @Override
    public RatingResponseDto mapToDto(Rating rating) {
        RatingResponseDto ratingResponseDto = new RatingResponseDto();
        ratingResponseDto.setId(rating.getId());
        ratingResponseDto.setBookID(rating.getBook().getId());
        ratingResponseDto.setMark(rating.getMark());
        return ratingResponseDto;
    }
}
