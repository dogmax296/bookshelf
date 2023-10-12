package com.dogmax.bookshelf.service;

import com.dogmax.bookshelf.model.Language;
import com.dogmax.bookshelf.model.Rating;

import java.util.List;
import java.util.Map;

public interface RatingService {
    Rating create(Rating rating);

    List<Rating> findAll(Map<String, String> params);

    Rating getById(Long id);

    void delete(Long id);

    Rating update(Rating rating);
}
