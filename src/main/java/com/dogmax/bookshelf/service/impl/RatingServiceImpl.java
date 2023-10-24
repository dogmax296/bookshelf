package com.dogmax.bookshelf.service.impl;

import com.dogmax.bookshelf.model.Rating;
import com.dogmax.bookshelf.repository.RatingRepository;
import com.dogmax.bookshelf.service.RatingService;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;

    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Rating create(Rating rating) {
        Rating r = ratingRepository.save(rating);
        /// update book rating
        return r;
    }

}
