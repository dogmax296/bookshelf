package com.dogmax.bookshelf.repository;

import com.dogmax.bookshelf.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
}
