package com.dogmax.bookshelf.service.mapper.impl;

import com.dogmax.bookshelf.dto.OrderRequestDto;
import com.dogmax.bookshelf.dto.OrderResponseDto;
import com.dogmax.bookshelf.model.Order;
import com.dogmax.bookshelf.service.mapper.DtoMapper;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class OrderDtoMapper implements DtoMapper<Order, OrderRequestDto, OrderResponseDto> {
    private final CartItemDtoMapper cartItemDtoMapper;

    public OrderDtoMapper(CartItemDtoMapper cartItemDtoMapper) {
        this.cartItemDtoMapper = cartItemDtoMapper;
    }

    @Override
    public Order mapToModel(OrderRequestDto orderRequestDto) {
        Order order = new Order();
        order.setCartItems(orderRequestDto.getCartItems()
                .stream()
                .map(cartItemDtoMapper::mapToModel)
                .collect(Collectors.toList()));
        order.setStatus(orderRequestDto.getStatus());
        return order;
    }

    @Override
    public OrderResponseDto mapToDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setCartItems(order.getCartItems()
                .stream()
                .map(cartItemDtoMapper::mapToDto)
                .collect(Collectors.toList()));
        orderResponseDto.setStatus(order.getStatus());
        return orderResponseDto;
    }
}
