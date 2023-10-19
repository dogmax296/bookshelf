package com.dogmax.bookshelf.service.impl;

import com.dogmax.bookshelf.model.Genre;
import com.dogmax.bookshelf.repository.GenreRepository;
import com.dogmax.bookshelf.service.GenreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Genre create(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public Genre getById(Long id) {
        return genreRepository.getReferenceById(id);
    }

    @Override
    public void delete(Long id) {
        genreRepository.deleteById(id);
    }

    @Override
    public Genre update(Genre genre) {
        return genreRepository.save(genre);
    }
}
