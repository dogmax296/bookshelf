package com.dogmax.bookshelf.service;

import com.dogmax.bookshelf.model.Format;

import java.util.List;

public interface FormatService {
    Format create(Format format);

    List<Format> findAll();

    Format getById(Long id);

    void delete(Long id);

    Format update(Format format);
}
