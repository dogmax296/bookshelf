package com.dogmax.bookshelf.service.mapper.impl;

import com.dogmax.bookshelf.dto.CartRequestDto;
import com.dogmax.bookshelf.dto.CartResponseDto;
import com.dogmax.bookshelf.model.Cart;
import com.dogmax.bookshelf.service.mapper.DtoMapper;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CartDtoMapper implements DtoMapper<Cart, CartRequestDto, CartResponseDto> {
    private final CartItemDtoMapper cartItemDtoMapper;

    public CartDtoMapper(CartItemDtoMapper cartItemDtoMapper) {
        this.cartItemDtoMapper = cartItemDtoMapper;
    }

    @Override
    public Cart mapToModel(CartRequestDto cartRequestDto) {
        Cart cart = new Cart();
        cart.setCartItems(cartRequestDto.getCartItems()
                .stream()
                .map(cartItemDtoMapper::mapToModel)
                .collect(Collectors.toList()));
        return cart;
    }

    @Override
    public CartResponseDto mapToDto(Cart cart) {
        CartResponseDto cartResponseDto = new CartResponseDto();
        cartResponseDto.setId(cart.getId());
        cartResponseDto.setCartItems(cart.getCartItems().
                stream()
                .map(cartItemDtoMapper::mapToDto)
                .collect(Collectors.toList()));
        return cartResponseDto;
    }
}
