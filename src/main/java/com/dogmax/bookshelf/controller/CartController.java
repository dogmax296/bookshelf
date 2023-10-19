package com.dogmax.bookshelf.controller;

import com.dogmax.bookshelf.dto.BookRequestDto;
import com.dogmax.bookshelf.dto.BookResponseDto;
import com.dogmax.bookshelf.dto.CartRequestDto;
import com.dogmax.bookshelf.dto.CartResponseDto;
import com.dogmax.bookshelf.dto.FormatRequestDto;
import com.dogmax.bookshelf.dto.FormatResponseDto;
import com.dogmax.bookshelf.model.Book;
import com.dogmax.bookshelf.model.Cart;
import com.dogmax.bookshelf.model.Format;
import com.dogmax.bookshelf.service.CartService;
import com.dogmax.bookshelf.service.mapper.DtoMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService service;
    private final DtoMapper<Cart, CartRequestDto, CartResponseDto> mapper;

    public CartController(CartService service, DtoMapper<Cart, CartRequestDto, CartResponseDto> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public CartResponseDto getById(@PathVariable Long id) {
        return mapper.mapToDto(service.getById(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public CartResponseDto update(@PathVariable Long id,
                                    @RequestBody CartRequestDto cartRequestDto) {
        Cart cart = mapper.mapToModel(cartRequestDto);
        cart.setId(id);
        return mapper.mapToDto(service.update(cart));
    }
}
