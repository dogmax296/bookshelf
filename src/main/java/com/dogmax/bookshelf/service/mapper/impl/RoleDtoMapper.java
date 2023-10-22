package com.dogmax.bookshelf.service.mapper.impl;

import com.dogmax.bookshelf.dto.RoleRequestDto;
import com.dogmax.bookshelf.dto.RoleResponseDto;
import com.dogmax.bookshelf.model.Role;
import com.dogmax.bookshelf.service.mapper.DtoMapper;
import org.springframework.stereotype.Service;

@Service
public class RoleDtoMapper implements DtoMapper<Role, RoleRequestDto, RoleResponseDto> {
    @Override
    public Role mapToModel(RoleRequestDto roleRequestDto) {
        Role role = new Role();
        role.setRole(roleRequestDto.getRole());
        return role;
    }

    @Override
    public RoleResponseDto mapToDto(Role role) {
        RoleResponseDto roleResponseDto = new RoleResponseDto();
        roleResponseDto.setId(role.getId());
        roleResponseDto.setRole(role.getRole());
        return roleResponseDto;
    }
}
