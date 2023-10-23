package com.dogmax.bookshelf.service;

import com.dogmax.bookshelf.model.Wishlist;

public interface WishlistService {
    Wishlist getById(Long id);

    Wishlist update(Wishlist wishlist);

}
