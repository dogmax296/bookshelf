package com.dogmax.bookshelf.service.mapper;

public interface ResponseDtoMapper<M, S> {
    S mapToDto(M m);
}
