package com.dogmax.bookshelf.controller;

import com.dogmax.bookshelf.dto.RoleRequestDto;
import com.dogmax.bookshelf.dto.RoleResponseDto;
import com.dogmax.bookshelf.model.Role;
import com.dogmax.bookshelf.service.RoleService;
import com.dogmax.bookshelf.service.mapper.DtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RoleController {
    private final RoleService service;
    private final DtoMapper<Role, RoleRequestDto, RoleResponseDto> mapper;

    public RoleController(RoleService service, DtoMapper<Role, RoleRequestDto, RoleResponseDto> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/add")
    public RoleResponseDto add(@RequestBody RoleRequestDto roleRequestDto) {
        return mapper.mapToDto(service.getById(service.create(mapper.mapToModel(roleRequestDto)).getId()));
    }

    @GetMapping
    public List<RoleResponseDto> getAll() {
        return service.findAll()
                .stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }
}
