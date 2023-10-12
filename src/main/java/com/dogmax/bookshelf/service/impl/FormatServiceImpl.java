package com.dogmax.bookshelf.service.impl;

import com.dogmax.bookshelf.model.Format;
import com.dogmax.bookshelf.repository.FormatRepository;
import com.dogmax.bookshelf.service.FormatService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FormatServiceImpl implements FormatService {

    private final FormatRepository formatRepository;

    public FormatServiceImpl(FormatRepository formatRepository) {
        this.formatRepository = formatRepository;
    }

    @Override
    public Format create(Format format) {
        return formatRepository.save(format);
    }

    @Override
    public List<Format> findAll(Map<String, String> params) {
        return formatRepository.findAll();
    }

    @Override
    public Format getById(Long id) {
        return formatRepository.getReferenceById(id);
    }

    @Override
    public void delete(Long id) {
        formatRepository.deleteById(id);
    }

    @Override
    public Format update(Format format) {
        return formatRepository.save(format);
    }
}
