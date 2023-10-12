package com.dogmax.bookshelf.service;

import com.dogmax.bookshelf.model.Format;

import java.util.List;
import java.util.Map;

public interface FormatService {
    Format create(Format format);

    List<Format> findAll(Map<String, String> params);

    Format getById(Long id);

    void delete(Long id);

    Format update(Format format);
}
