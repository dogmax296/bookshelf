package com.dogmax.bookshelf.controller;

import com.dogmax.bookshelf.dto.GenreRequestDto;
import com.dogmax.bookshelf.dto.GenreResponseDto;
import com.dogmax.bookshelf.model.Genre;
import com.dogmax.bookshelf.service.GenreService;
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
@RequestMapping("/genres")
public class GenreController {

    private final GenreService service;
    private final DtoMapper<Genre, GenreRequestDto, GenreResponseDto> mapper;

    public GenreController(GenreService service, DtoMapper<Genre,
            GenreRequestDto, GenreResponseDto> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/add")
    public GenreResponseDto add(@RequestBody GenreRequestDto genreRequestDto) {
        return mapper.mapToDto(service.getById(service.create(mapper.mapToModel(genreRequestDto)).getId()));
    }

    @GetMapping
    public List<GenreResponseDto> getAll() {
        return service.findAll()
                .stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public GenreResponseDto getById(@PathVariable Long id) {
        return mapper.mapToDto(service.getById(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public GenreResponseDto update(@PathVariable Long id,
                                    @RequestBody GenreRequestDto genreRequestDto) {
        Genre genre = mapper.mapToModel(genreRequestDto);
        genre.setId(id);
        return mapper.mapToDto(service.update(genre));
    }


}
