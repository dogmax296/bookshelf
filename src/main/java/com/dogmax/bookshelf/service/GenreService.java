package com.dogmax.bookshelf.service;

import com.dogmax.bookshelf.model.Genre;

import java.util.List;

public interface GenreService {
    Genre create(Genre genre);

    List<Genre> findAll();

    Genre getById(Long id);

    void delete(Long id);

    Genre update(Genre genre);
}
