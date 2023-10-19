package com.dogmax.bookshelf.service.mapper.impl;

import com.dogmax.bookshelf.dto.RoleRequestDto;
import com.dogmax.bookshelf.dto.RoleResponseDto;
import com.dogmax.bookshelf.dto.UserRequestDto;
import com.dogmax.bookshelf.dto.UserResponseDto;
import com.dogmax.bookshelf.model.Order;
import com.dogmax.bookshelf.model.Role;
import com.dogmax.bookshelf.model.User;
import com.dogmax.bookshelf.service.mapper.DtoMapper;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserDtoMapper implements DtoMapper<User, UserRequestDto, UserResponseDto> {

    private final DtoMapper<Role, RoleRequestDto, RoleResponseDto> rolesMapper;

    public UserDtoMapper(DtoMapper<Role, RoleRequestDto, RoleResponseDto> rolesMapper) {
        this.rolesMapper = rolesMapper;
    }

    @Override
    public User mapToModel(UserRequestDto userRequestDto) {
        User user = new User();
        user.setLogin(userRequestDto.getLogin());
        user.setPassword(userRequestDto.getPassword());
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
        userResponseDto.setCartId(user.getCart().getId());
        userResponseDto.setWishlistId(user.getWishlist().getId());
        userResponseDto.setOrderIds(user.getOrders()
                .stream()
                .map(Order::getId)
                .collect(Collectors.toList())
        );
        userResponseDto.setStatus(user.getStatus());
        return userResponseDto;
    }
}
