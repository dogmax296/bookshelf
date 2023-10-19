package com.dogmax.bookshelf.service.mapper.impl;

import com.dogmax.bookshelf.dto.CartItemRequestDto;
import com.dogmax.bookshelf.dto.CartItemResponseDto;
import com.dogmax.bookshelf.model.CartItem;
import com.dogmax.bookshelf.repository.BookRepository;
import com.dogmax.bookshelf.service.mapper.DtoMapper;
import org.springframework.stereotype.Service;

@Service
public class CartItemDtoMapper implements DtoMapper<CartItem, CartItemRequestDto, CartItemResponseDto> {
    private final BookRepository bookRepository;

    public CartItemDtoMapper(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public CartItem mapToModel(CartItemRequestDto cartItemRequestDto) {
        CartItem cartItem = new CartItem();
        cartItem.setBook(bookRepository.getReferenceById(cartItemRequestDto.getBookId()));
        cartItem.setQuantity(cartItemRequestDto.getQuantity());
        return cartItem;
    }

    @Override
    public CartItemResponseDto mapToDto(CartItem cartItem) {
        CartItemResponseDto cartItemResponseDto = new CartItemResponseDto();
        cartItemResponseDto.setId(cartItem.getId());
        cartItemResponseDto.setBookId(cartItem.getBook().getId());
        cartItemResponseDto.setQuantity(cartItem.getQuantity());
        return cartItemResponseDto;
    }
}
