package com.dogmax.bookshelf.service;

import com.dogmax.bookshelf.model.Order;

import java.util.List;

public interface OrderService {
    Order create(Order order);

    List<Order> findAll();

    Order getById(Long id);

    void delete(Long id);

    Order update(Order order);
}
