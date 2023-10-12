package com.dogmax.bookshelf.service;

import com.dogmax.bookshelf.model.Genre;

import java.util.List;
import java.util.Map;

public interface GenreService {
    Genre create(Genre genre);

    List<Genre> findAll(Map<String, String> params);

    Genre getById(Long id);

    void delete(Long id);

    Genre update(Genre genre);
}
