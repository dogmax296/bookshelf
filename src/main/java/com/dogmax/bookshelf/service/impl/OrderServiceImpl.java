package com.dogmax.bookshelf.service.impl;

import com.dogmax.bookshelf.model.Order;
import com.dogmax.bookshelf.repository.OrderRepository;
import com.dogmax.bookshelf.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;

    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Order create(Order order) {
        return repository.save(order);
    }

    @Override
    public List<Order> findAll() {
        return repository.findAll();
    }

    @Override
    public Order getById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public void delete(Long id) {
        Order order = repository.getReferenceById(id);
        order.setStatus("DELETED");
        repository.save(order);
    }

    @Override
    public Order update(Order order) {
        return repository.save(order);
    }
}
