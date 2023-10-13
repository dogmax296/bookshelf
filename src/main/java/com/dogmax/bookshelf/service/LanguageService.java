package com.dogmax.bookshelf.service;

import com.dogmax.bookshelf.model.Language;

import java.util.List;
import java.util.Map;

public interface LanguageService {
    Language create(Language language);

    List<Language> findAll();

    Language getById(Long id);

    void delete(Long id);

    Language update(Language language);
}
