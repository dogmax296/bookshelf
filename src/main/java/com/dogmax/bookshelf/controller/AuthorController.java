package com.dogmax.bookshelf.controller;

import com.dogmax.bookshelf.dto.AuthorRequestDto;
import com.dogmax.bookshelf.dto.AuthorResponseDto;
import com.dogmax.bookshelf.model.Author;
import com.dogmax.bookshelf.service.AuthorService;
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
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService service;
    private final DtoMapper<Author, AuthorRequestDto, AuthorResponseDto> mapper;

    public AuthorController(AuthorService service, DtoMapper<Author,
            AuthorRequestDto, AuthorResponseDto> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/add")
    public AuthorResponseDto add(@RequestBody AuthorRequestDto authorRequestDto){
        return mapper.mapToDto(service.getById(service.create(mapper.mapToModel(authorRequestDto)).getId()));
    }

    @GetMapping
    public List<AuthorResponseDto> getAll(){
        return service.findAll()
                .stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AuthorResponseDto getById(@PathVariable Long id){
        return mapper.mapToDto(service.getById(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @PutMapping("/{id}")
    public AuthorResponseDto update(@PathVariable Long id,
                                    @RequestBody AuthorRequestDto authorRequestDto){
        Author author = mapper.mapToModel(authorRequestDto);
        author.setId(id);
        return mapper.mapToDto(service.update(author));
    }




}
