package com.dogmax.bookshelf.controller;

import com.dogmax.bookshelf.dto.LanguageRequestDto;
import com.dogmax.bookshelf.dto.LanguageResponseDto;
import com.dogmax.bookshelf.model.Language;
import com.dogmax.bookshelf.service.LanguageService;
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
@RequestMapping("/languages")
public class LanguageController {

    private final LanguageService service;
    private final DtoMapper<Language, LanguageRequestDto, LanguageResponseDto> mapper;

    public LanguageController(LanguageService service,
                              DtoMapper<Language, LanguageRequestDto, LanguageResponseDto> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/add")
    public LanguageResponseDto add(@RequestBody LanguageRequestDto languageRequestDto) {
        return mapper.mapToDto(service.getById(service.create(mapper.mapToModel(languageRequestDto)).getId()));
    }

    @GetMapping
    public List<LanguageResponseDto> getAll() {
        return service.findAll()
                .stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public LanguageResponseDto getById(@PathVariable Long id) {
        return mapper.mapToDto(service.getById(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public LanguageResponseDto update(@PathVariable Long id,
                                      @RequestBody LanguageRequestDto languageRequestDto) {
        Language language = mapper.mapToModel(languageRequestDto);
        language.setId(id);
        return mapper.mapToDto(service.update(language));
    }


}
