package com.dogmax.bookshelf.controller;

import com.dogmax.bookshelf.dto.FormatRequestDto;
import com.dogmax.bookshelf.dto.FormatResponseDto;
import com.dogmax.bookshelf.model.Format;
import com.dogmax.bookshelf.service.FormatService;
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
@RequestMapping("/formats")
public class FormatController {

    private final FormatService service;
    private final DtoMapper<Format, FormatRequestDto, FormatResponseDto> mapper;

    public FormatController(FormatService service, DtoMapper<Format,
            FormatRequestDto, FormatResponseDto> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/add")
    public FormatResponseDto add(@RequestBody FormatRequestDto formatRequestDto) {
        return mapper.mapToDto(service.getById(service.create(mapper.mapToModel(formatRequestDto)).getId()));
    }

    @GetMapping
    public List<FormatResponseDto> getAll() {
        return service.findAll()
                .stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public FormatResponseDto getById(@PathVariable Long id) {
        return mapper.mapToDto(service.getById(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public FormatResponseDto update(@PathVariable Long id,
                                    @RequestBody FormatRequestDto formatRequestDto) {
        Format format = mapper.mapToModel(formatRequestDto);
        format.setId(id);
        return mapper.mapToDto(service.update(format));
    }


}
