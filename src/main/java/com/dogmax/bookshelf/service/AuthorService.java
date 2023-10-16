package com.dogmax.bookshelf.service;

import com.dogmax.bookshelf.model.Author;

import java.util.List;

public interface AuthorService {
    Author create(Author author);

    List<Author> findAll();

    Author getById(Long id);

    void delete(Long id);

    Author update(Author author);
}
