package com.dogmax.bookshelf.service.impl;

import com.dogmax.bookshelf.model.Cart;
import com.dogmax.bookshelf.repository.CartRepository;
import com.dogmax.bookshelf.service.CartService;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository repository;

    public CartServiceImpl(CartRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cart getById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Cart update(Cart cart) {
        return repository.save(cart);
    }

    @Override
    public void delete(Long id) {
        Cart cart = repository.getReferenceById(id);
        cart.setCartItems(Collections.emptyList());
    }
}
