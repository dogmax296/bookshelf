package com.dogmax.bookshelf.controller;

import com.dogmax.bookshelf.dto.RatingRequestDto;
import com.dogmax.bookshelf.dto.RatingResponseDto;
import com.dogmax.bookshelf.model.Rating;
import com.dogmax.bookshelf.service.RatingService;
import com.dogmax.bookshelf.service.mapper.DtoMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final RatingService service;
    private final DtoMapper<Rating, RatingRequestDto, RatingResponseDto> mapper;

    public RatingController(RatingService service,
                            DtoMapper<Rating, RatingRequestDto, RatingResponseDto> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/add")
    public RatingResponseDto add(@RequestBody RatingRequestDto ratingRequestDto) {
        return mapper.mapToDto(service.getById(service.create(mapper.mapToModel(ratingRequestDto)).getId()));
    }

    @GetMapping
    public List<RatingResponseDto> getAll() {
        return service.findAll()
                .stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public RatingResponseDto getById(@PathVariable Long id) {
        return mapper.mapToDto(service.getById(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public RatingResponseDto update(@PathVariable Long id,
                                    @RequestBody RatingRequestDto ratingRequestDto) {
        Rating rating = mapper.mapToModel(ratingRequestDto);
        rating.setId(id);
        return mapper.mapToDto(service.update(rating));
    }


}
