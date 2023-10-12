package com.dogmax.bookshelf.service.mapper.impl;

import com.dogmax.bookshelf.dto.AvailabilityRequestDto;
import com.dogmax.bookshelf.dto.AvailabilityResponseDto;
import com.dogmax.bookshelf.model.Availability;
import com.dogmax.bookshelf.service.mapper.DtoMapper;

public class AvailabilityDtoMapper implements DtoMapper<Availability, AvailabilityRequestDto, AvailabilityResponseDto> {
    @Override
    public Availability mapToModel(AvailabilityRequestDto availabilityRequestDto) {
        Availability availability = new Availability();
        availability.setAvailability(availabilityRequestDto.getAvailability());
        return availability;
    }

    @Override
    public AvailabilityResponseDto mapToDto(Availability availability) {
        AvailabilityResponseDto availabilityResponseDto = new AvailabilityResponseDto();
        availabilityResponseDto.setId(availability.getId());
        availabilityResponseDto.setAvailability(availability.getAvailability());
        return availabilityResponseDto;
    }
}
