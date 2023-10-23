package com.dogmax.bookshelf.service.impl;

import com.dogmax.bookshelf.model.Wishlist;
import com.dogmax.bookshelf.repository.WishlistRepository;
import com.dogmax.bookshelf.service.WishlistService;
import org.springframework.stereotype.Service;

@Service
public class WishlistServiceImpl implements WishlistService {

    private final WishlistRepository repository;

    public WishlistServiceImpl(WishlistRepository repository) {
        this.repository = repository;
    }

    @Override
    public Wishlist update(Wishlist wishlist) {
        return repository.save(wishlist);
    }

    @Override
    public Wishlist getById(Long id) {
        return repository.getReferenceById(id);
    }
}
