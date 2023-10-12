package com.dogmax.bookshelf.service.mapper;

public interface RequestDtoMapper<M, R> {
    M mapToModel(R r);
}
