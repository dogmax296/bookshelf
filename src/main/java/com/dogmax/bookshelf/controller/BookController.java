package com.dogmax.bookshelf.controller;

import com.dogmax.bookshelf.dto.BookRequestDto;
import com.dogmax.bookshelf.dto.BookResponseDto;
import com.dogmax.bookshelf.model.Book;
import com.dogmax.bookshelf.service.BookService;
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
@RequestMapping("/books")
public class BookController {

    private final BookService service;
    private final DtoMapper<Book, BookRequestDto, BookResponseDto> mapper;

    public BookController(BookService service, DtoMapper<Book,
            BookRequestDto, BookResponseDto> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/add")
    public BookResponseDto add(@RequestBody BookRequestDto bookRequestDto) {
        return mapper.mapToDto(service.getById(service.create(mapper.mapToModel(bookRequestDto)).getId()));
    }

    @GetMapping
    public List<BookResponseDto> getAll() {
        return service.findAll()
                .stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BookResponseDto getById(@PathVariable Long id) {
        return mapper.mapToDto(service.getById(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public BookResponseDto update(@PathVariable Long id,
                                  @RequestBody BookRequestDto bookRequestDto) {
        Book book = mapper.mapToModel(bookRequestDto);
        book.setId(id);
        return mapper.mapToDto(service.update(book));
    }


}
