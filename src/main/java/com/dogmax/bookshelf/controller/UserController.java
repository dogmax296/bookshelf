package com.dogmax.bookshelf.controller;

import com.dogmax.bookshelf.dto.UserRequestDto;
import com.dogmax.bookshelf.dto.UserResponseDto;
import com.dogmax.bookshelf.model.User;
import com.dogmax.bookshelf.service.UserService;
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
@RequestMapping("/users")
public class UserController {
    private final UserService service;
    private final DtoMapper<User, UserRequestDto, UserResponseDto> mapper;

    public UserController(UserService service, DtoMapper<User, UserRequestDto, UserResponseDto> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/add")
    public UserResponseDto add(@RequestBody UserRequestDto userRequestDto) {
        return mapper.mapToDto(service.getById(service.create(mapper.mapToModel(userRequestDto)).getId()));
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        return service.findAll()
                .stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserResponseDto getById(@PathVariable Long id) {
        return mapper.mapToDto(service.getById(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public UserResponseDto update(@PathVariable Long id,
                                  @RequestBody UserRequestDto userRequestDto) {
        User user = mapper.mapToModel(userRequestDto);
        user.setId(id);
        return mapper.mapToDto(service.update(user));
    }

}
