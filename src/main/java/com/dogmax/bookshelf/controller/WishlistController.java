package com.dogmax.bookshelf.controller;

import com.dogmax.bookshelf.dto.WishlistRequestDto;
import com.dogmax.bookshelf.dto.WishlistResponseDto;
import com.dogmax.bookshelf.model.Wishlist;
import com.dogmax.bookshelf.service.BookService;
import com.dogmax.bookshelf.service.WishlistService;
import com.dogmax.bookshelf.service.mapper.DtoMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {

    private final WishlistService wishlistService;
    private final BookService bookService;
    private final DtoMapper<Wishlist, WishlistRequestDto, WishlistResponseDto> mapper;

    public WishlistController(WishlistService wishlistService,
                              BookService bookService,
                              DtoMapper<Wishlist, WishlistRequestDto, WishlistResponseDto> mapper) {
        this.wishlistService = wishlistService;
        this.bookService = bookService;
        this.mapper = mapper;
    }
    @GetMapping("/{id}")
    public WishlistResponseDto getById(@PathVariable Long id) {
        return mapper.mapToDto(wishlistService.getById(id));
    }
    @PutMapping("/{id}")
    public WishlistResponseDto update(@PathVariable Long id,
                                      @RequestBody WishlistRequestDto wishlistRequestDto) {
        Wishlist wishlist = wishlistService.getById(id);
        wishlist.getBooks().add(bookService.getById(wishlistRequestDto.getBookID()));
        return mapper.mapToDto(wishlistService.update(wishlist));
    }
    @DeleteMapping("/{id}")
    public WishlistResponseDto delete(@PathVariable Long id,
                                      @RequestBody WishlistRequestDto wishlistRequestDto) {
        Wishlist wishlist = wishlistService.getById(id);
        wishlist.getBooks().remove(bookService.getById(wishlistRequestDto.getBookID()));
        return mapper.mapToDto(wishlistService.update(wishlist));
    }
}
