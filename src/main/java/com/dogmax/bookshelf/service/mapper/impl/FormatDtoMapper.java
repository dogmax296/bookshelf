package com.dogmax.bookshelf.service.mapper.impl;

import com.dogmax.bookshelf.dto.FormatRequestDto;
import com.dogmax.bookshelf.dto.FormatResponseDto;
import com.dogmax.bookshelf.model.Format;
import com.dogmax.bookshelf.service.mapper.DtoMapper;
import org.springframework.stereotype.Service;

@Service
public class FormatDtoMapper implements DtoMapper<Format, FormatRequestDto, FormatResponseDto> {

    @Override
    public Format mapToModel(FormatRequestDto formatRequestDto) {
        Format format = new Format();
        format.setFormat(formatRequestDto.getFormat());
        return format;
    }

    @Override
    public FormatResponseDto mapToDto(Format format) {
        FormatResponseDto formatResponseDto = new FormatResponseDto();
        formatResponseDto.setId(format.getId());
        formatResponseDto.setFormat(format.getFormat());
        return formatResponseDto;
    }
}
