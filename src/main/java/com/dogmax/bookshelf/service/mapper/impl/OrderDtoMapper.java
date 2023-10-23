package com.dogmax.bookshelf.service.mapper.impl;

import com.dogmax.bookshelf.dto.OrderRequestDto;
import com.dogmax.bookshelf.dto.OrderResponseDto;
import com.dogmax.bookshelf.model.CartItem;
import com.dogmax.bookshelf.model.Order;
import com.dogmax.bookshelf.repository.CartItemRepository;
import com.dogmax.bookshelf.service.CartService;
import com.dogmax.bookshelf.service.mapper.DtoMapper;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class OrderDtoMapper implements DtoMapper<Order, OrderRequestDto, OrderResponseDto> {
    private final CartItemDtoMapper cartItemDtoMapper;
    private final CartService cartService;
    public OrderDtoMapper(CartItemDtoMapper cartItemDtoMapper,
                          CartService cartService) {
        this.cartItemDtoMapper = cartItemDtoMapper;
        this.cartService = cartService;
    }

    @Override
    public Order mapToModel(OrderRequestDto orderRequestDto) {
        Order order = new Order();
        order.setCartItems(cartService.getById(orderRequestDto.getCartId()).getCartItems());
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
