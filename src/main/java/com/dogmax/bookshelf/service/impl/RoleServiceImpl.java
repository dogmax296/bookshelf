package com.dogmax.bookshelf.service.impl;

import com.dogmax.bookshelf.model.Role;
import com.dogmax.bookshelf.repository.RoleRepository;
import com.dogmax.bookshelf.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;

    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Role create(Role role) {
        return repository.save(role);
    }

    @Override
    public List<Role> findAll() {
        return repository.findAll();
    }

    @Override
    public Role getById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Optional<Role> findByRole(String role) {
        return repository.findByRole(role);
    }
}
