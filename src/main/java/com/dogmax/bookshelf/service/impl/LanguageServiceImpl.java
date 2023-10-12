package com.dogmax.bookshelf.service.impl;

import com.dogmax.bookshelf.model.Language;
import com.dogmax.bookshelf.repository.LanguageRepository;
import com.dogmax.bookshelf.service.LanguageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;

    public LanguageServiceImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public Language create(Language language) {
        return languageRepository.save(language);
    }

    @Override
    public List<Language> findAll(Map<String, String> params) {
        return languageRepository.findAll();
    }

    @Override
    public Language getById(Long id) {
        return languageRepository.getReferenceById(id);
    }

    @Override
    public void delete(Long id) {
        languageRepository.deleteById(id);
    }

    @Override
    public Language update(Language language) {
        return languageRepository.save(language);
    }
}
