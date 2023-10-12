package com.dogmax.bookshelf.service.impl;

import com.dogmax.bookshelf.model.Rating;
import com.dogmax.bookshelf.repository.RatingRepository;
import com.dogmax.bookshelf.service.RatingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;

    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Rating create(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> findAll(Map<String, String> params) {
        return ratingRepository.findAll();
    }

    @Override
    public Rating getById(Long id) {
        return ratingRepository.getReferenceById(id);
    }

    @Override
    public void delete(Long id) {
        ratingRepository.deleteById(id);
    }

    @Override
    public Rating update(Rating rating) {
        return ratingRepository.save(rating);
    }
}
