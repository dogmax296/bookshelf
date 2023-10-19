package com.dogmax.bookshelf.service;

import com.dogmax.bookshelf.model.Rating;

import java.util.List;

public interface RatingService {
    Rating create(Rating rating);

    List<Rating> findAll();

    Rating getById(Long id);

    void delete(Long id);

    Rating update(Rating rating);
}
