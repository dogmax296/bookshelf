package com.dogmax.bookshelf.service.impl;

import com.dogmax.bookshelf.model.Author;
import com.dogmax.bookshelf.repository.AuthorRepository;
import com.dogmax.bookshelf.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author create(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author getById(Long id) {
        return authorRepository.getReferenceById(id);
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Author update(Author author) {
        return authorRepository.save(author);
    }
}
