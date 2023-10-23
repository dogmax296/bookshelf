package com.dogmax.bookshelf.service.mapper.impl;

import com.dogmax.bookshelf.dto.WishlistRequestDto;
import com.dogmax.bookshelf.dto.WishlistResponseDto;
import com.dogmax.bookshelf.model.Book;
import com.dogmax.bookshelf.model.Wishlist;
import com.dogmax.bookshelf.service.mapper.DtoMapper;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class WishlistDtoMapper implements DtoMapper<Wishlist, WishlistRequestDto, WishlistResponseDto> {

    @Override
    public Wishlist mapToModel(WishlistRequestDto wishlistAddRequestDto) {
        return null;
    }

    @Override
    public WishlistResponseDto mapToDto(Wishlist wishlist) {
        WishlistResponseDto wishlistResponseDto = new WishlistResponseDto();
        wishlistResponseDto.setId(wishlist.getId());
        wishlistResponseDto.setBookIDS(wishlist.getBooks().stream().map(Book::getId).collect(Collectors.toList()));
        return wishlistResponseDto;
    }
}
