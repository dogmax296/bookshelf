package com.dogmax.bookshelf.service.impl;

import com.dogmax.bookshelf.model.Book;
import com.dogmax.bookshelf.model.Rating;
import com.dogmax.bookshelf.repository.BookRepository;
import com.dogmax.bookshelf.repository.RatingRepository;
import com.dogmax.bookshelf.service.RatingService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {
    private final BookRepository bookRepository;
    private final RatingRepository ratingRepository;

    public RatingServiceImpl(BookRepository bookRepository,
                             RatingRepository ratingRepository) {
        this.bookRepository = bookRepository;
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Rating create(Rating rating) {
        Rating r = ratingRepository.save(rating);
        Book book = rating.getBook();
        List<BigDecimal> marks = ratingRepository.getAllByBook_Id(book.getId())
                .stream()
                .map(Rating::getMark)
                .toList();
        BigDecimal average = marks.stream().reduce(BigDecimal.ZERO, BigDecimal::add).divide(BigDecimal.valueOf(marks.size()), RoundingMode.UP);
        book.setRating(average);
        bookRepository.save(book);
        return r;
    }

}
