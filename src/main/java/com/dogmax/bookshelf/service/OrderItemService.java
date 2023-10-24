package com.dogmax.bookshelf.service;

import com.dogmax.bookshelf.model.OrderItem;

public interface OrderItemService {
    OrderItem create(OrderItem orderItem);

    OrderItem getById(Long id);

    void delete(Long id);

    OrderItem update(OrderItem orderItem);
}
