package com.dogmax.bookshelf.controller;

import com.dogmax.bookshelf.dto.OrderRequestDto;
import com.dogmax.bookshelf.dto.OrderResponseDto;
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
    private final OrderService service;
    private final DtoMapper<Order, OrderRequestDto, OrderResponseDto> mapper;

    public OrderController(OrderService orderService, DtoMapper<Order, OrderRequestDto, OrderResponseDto> mapper) {
        this.service = orderService;
        this.mapper = mapper;
    }

    @PostMapping("/add")
    public OrderResponseDto add(@RequestBody OrderRequestDto orderRequestDto) {
        return mapper.mapToDto(service.getById(service.create(mapper.mapToModel(orderRequestDto)).getId()));
    }

    @GetMapping
    public List<OrderResponseDto> getAll() {
        return service.findAll()
                .stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public OrderResponseDto getById(@PathVariable Long id) {
        return mapper.mapToDto(service.getById(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public OrderResponseDto update(@PathVariable Long id,
                                   @RequestBody OrderRequestDto orderRequestDto) {
        Order order = mapper.mapToModel(orderRequestDto);
        order.setId(id);
        return mapper.mapToDto(service.update(order));
    }

}
