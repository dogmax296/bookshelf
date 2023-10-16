package com.dogmax.bookshelf.service.mapper.impl;

import com.dogmax.bookshelf.dto.LanguageRequestDto;
import com.dogmax.bookshelf.dto.LanguageResponseDto;
import com.dogmax.bookshelf.dto.RatingRequestDto;
import com.dogmax.bookshelf.dto.RatingResponseDto;
import com.dogmax.bookshelf.model.Language;
import com.dogmax.bookshelf.model.Rating;
import com.dogmax.bookshelf.service.mapper.DtoMapper;
import org.springframework.stereotype.Service;

@Service
public class RatingDtoMapper implements DtoMapper<Rating, RatingRequestDto, RatingResponseDto> {
    @Override
    public Rating mapToModel(RatingRequestDto ratingRequestDto) {
        Rating rating = new Rating();
        rating.setMark(ratingRequestDto.getMark());
        return rating;
    }

    @Override
    public RatingResponseDto mapToDto(Rating rating) {
        RatingResponseDto ratingResponseDto = new RatingResponseDto();
        ratingResponseDto.setId(rating.getId());
        ratingResponseDto.setMark(ratingResponseDto.getMark());
        return ratingResponseDto;
    }
}
