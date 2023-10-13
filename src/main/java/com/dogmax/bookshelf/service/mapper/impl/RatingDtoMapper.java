package com.dogmax.bookshelf.service.mapper.impl;

import com.dogmax.bookshelf.dto.LanguageRequestDto;
import com.dogmax.bookshelf.dto.LanguageResponseDto;
import com.dogmax.bookshelf.model.Language;
import com.dogmax.bookshelf.service.mapper.DtoMapper;
import org.springframework.stereotype.Service;

@Service
public class RatingDtoMapper implements DtoMapper<Language, LanguageRequestDto, LanguageResponseDto> {
    @Override
    public Language mapToModel(LanguageRequestDto languageRequestDto) {
        Language language = new Language();
        language.setLanguage(languageRequestDto.getLanguage());
        return language;
    }

    @Override
    public LanguageResponseDto mapToDto(Language language) {
        LanguageResponseDto languageResponseDto = new LanguageResponseDto();
        languageResponseDto.setId(language.getId());
        languageResponseDto.setLanguage(languageResponseDto.getLanguage());
        return languageResponseDto;
    }
}
