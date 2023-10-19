package com.dogmax.bookshelf.service;


import com.dogmax.bookshelf.model.Cart;

public interface CartService {

    Cart getById(Long id);

    Cart update(Cart cart);
    void delete(Long id);
}
