package com.dogmax.bookshelf.controller;

import com.dogmax.bookshelf.dto.OrderRequestDto;
import com.dogmax.bookshelf.dto.OrderResponseDto;
import com.dogmax.bookshelf.dto.OrderStatusUpdateRequestDto;
import com.dogmax.bookshelf.model.Order;
import com.dogmax.bookshelf.service.OrderService;
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
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final DtoMapper<Order, OrderRequestDto, OrderResponseDto> orderDtoMapper;

    public OrderController(OrderService orderService,
                           DtoMapper<Order, OrderRequestDto, OrderResponseDto> orderDtoMapper) {
        this.orderService = orderService;
        this.orderDtoMapper = orderDtoMapper;
    }

    @PostMapping("/add")
    public OrderResponseDto add(@RequestBody OrderRequestDto orderRequestDto) {
        return orderDtoMapper.mapToDto(orderService.getById(orderService.create(orderDtoMapper.mapToModel(orderRequestDto)).getId()));
    }

    @GetMapping
    public List<OrderResponseDto> getAll() {
        return orderService.findAll()
                .stream()
                .map(orderDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public OrderResponseDto getById(@PathVariable Long id) {
        return orderDtoMapper.mapToDto(orderService.getById(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        orderService.delete(id);
    }

    @PutMapping("/{id}")
    public OrderResponseDto update(@PathVariable Long id,
                                   @RequestBody OrderRequestDto orderRequestDto) {
        Order order = orderDtoMapper.mapToModel(orderRequestDto);
        order.setId(id);
        return orderDtoMapper.mapToDto(orderService.update(order));
    }

    @PutMapping("/{id}")
    public OrderResponseDto updateStatus(@PathVariable Long id,
                                   @RequestBody OrderStatusUpdateRequestDto orderStatusUpdateRequestDto) {
        Order order = orderService.getById(id);
        order.setStatus(orderStatusUpdateRequestDto.getStatus());
        return orderDtoMapper.mapToDto(orderService.update(order));
    }

}
