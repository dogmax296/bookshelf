package com.dogmax.bookshelf.service.mapper.impl;

import com.dogmax.bookshelf.dto.RoleRequestDto;
import com.dogmax.bookshelf.dto.RoleResponseDto;
import com.dogmax.bookshelf.dto.UserRequestDto;
import com.dogmax.bookshelf.dto.UserResponseDto;
import com.dogmax.bookshelf.model.Order;
import com.dogmax.bookshelf.model.Role;
import com.dogmax.bookshelf.model.User;
import com.dogmax.bookshelf.service.RoleService;
import com.dogmax.bookshelf.service.mapper.DtoMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDtoMapper implements DtoMapper<User, UserRequestDto, UserResponseDto> {

    private final DtoMapper<Role, RoleRequestDto, RoleResponseDto> rolesMapper;
    private final RoleService roleService;

    public UserDtoMapper(DtoMapper<Role, RoleRequestDto, RoleResponseDto> rolesMapper, RoleService roleService) {
        this.rolesMapper = rolesMapper;
        this.roleService = roleService;
    }

    @Override
    public User mapToModel(UserRequestDto userRequestDto) {
        User user = new User();
        user.setLogin(userRequestDto.getLogin());
        user.setPassword(userRequestDto.getPassword());
        List<Role> roles = userRequestDto.getRolesIDS()
                .stream()
                .map(roleService::getById)
                .toList();
        if (roles.isEmpty()) roles = List.of(roleService.getById(1L));
        user.setRoles(roles);
        user.setStatus("ACTIVE");
        return user;
    }

    @Override
    public UserResponseDto mapToDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setLogin(user.getLogin());
        userResponseDto.setRoles(user.getRoles()
                .stream()
                .map(rolesMapper::mapToDto)
                .collect(Collectors.toList())
        );
        List<Order> orders = user.getOrders();
        if (orders != null) userResponseDto.setOrderIDS(orders
                .stream()
                .map(Order::getId)
                .collect(Collectors.toList())
        );
        orders = Collections.EMPTY_LIST;
        userResponseDto.setStatus(user.getStatus());
        return userResponseDto;
    }
}
