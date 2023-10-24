package com.dogmax.bookshelf.service.mapper.impl;

import com.dogmax.bookshelf.dto.OrderItemRequestDto;
import com.dogmax.bookshelf.dto.OrderItemResponseDto;
import com.dogmax.bookshelf.dto.OrderRequestDto;
import com.dogmax.bookshelf.dto.OrderResponseDto;
import com.dogmax.bookshelf.model.Order;
import com.dogmax.bookshelf.model.OrderItem;
import com.dogmax.bookshelf.service.mapper.DtoMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderDtoMapper implements DtoMapper<Order, OrderRequestDto, OrderResponseDto> {
    private final DtoMapper<OrderItem, OrderItemRequestDto, OrderItemResponseDto> orderItemDtoMapper;

    public OrderDtoMapper(DtoMapper<OrderItem, OrderItemRequestDto, OrderItemResponseDto> orderItemDtoMapper) {
        this.orderItemDtoMapper = orderItemDtoMapper;
    }

    @Override
    public Order mapToModel(OrderRequestDto orderRequestDto) {
        Order order = new Order();
        order.setStatus("NEW");
        order.setOrderItems(orderRequestDto.getOrderItems().stream().map(orderItemDtoMapper::mapToModel).toList());
        return order;
    }

    @Override
    public OrderResponseDto mapToDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setOrderItems(order.getOrderItems().stream().map(orderItemDtoMapper::mapToDto).toList());
        orderResponseDto.setStatus(order.getStatus());
        return orderResponseDto;
    }
}
