package com.dogmax.bookshelf.service.mapper.impl;

import com.dogmax.bookshelf.dto.OrderItemRequestDto;
import com.dogmax.bookshelf.dto.OrderItemResponseDto;
import com.dogmax.bookshelf.model.OrderItem;
import com.dogmax.bookshelf.service.BookService;
import com.dogmax.bookshelf.service.mapper.DtoMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderItemDtoMapper implements DtoMapper<OrderItem, OrderItemRequestDto, OrderItemResponseDto> {

    private final BookService service;

    public OrderItemDtoMapper(BookService service) {
        this.service = service;
    }

    @Override
    public OrderItem mapToModel(OrderItemRequestDto orderItemRequestDto) {
        OrderItem orderItem = new OrderItem();
        orderItem.setBook(service.getById(orderItemRequestDto.getBookID()));
        orderItem.setQuantity(orderItemRequestDto.getQuantity());
        orderItem.setSum(service.getById(orderItemRequestDto.getBookID()).getPrice().multiply(orderItemRequestDto.getQuantity()));
        return orderItem;
    }

    @Override
    public OrderItemResponseDto mapToDto(OrderItem orderItem) {
        OrderItemResponseDto orderItemResponseDto = new OrderItemResponseDto();
        orderItemResponseDto.setId(orderItem.getId());
        orderItemResponseDto.setBookID(orderItem.getBook().getId());
        orderItemResponseDto.setQuantity(orderItem.getQuantity());
        orderItemResponseDto.setSum(orderItem.getSum());
        return orderItemResponseDto;
    }
}
