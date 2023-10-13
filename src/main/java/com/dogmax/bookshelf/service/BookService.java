package com.dogmax.bookshelf.service;

import com.dogmax.bookshelf.model.Book;

import java.util.List;
import java.util.Map;

public interface BookService {
    Book create(Book book);

    List<Book> findAll();

    Book getById(Long id);

    void delete(Long id);

    Book update(Book book);
}
