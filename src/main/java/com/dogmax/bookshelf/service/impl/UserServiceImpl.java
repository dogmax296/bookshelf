package com.dogmax.bookshelf.service.impl;

import com.dogmax.bookshelf.model.User;
import com.dogmax.bookshelf.repository.UserRepository;
import com.dogmax.bookshelf.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User getById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public void delete(Long id) {
        User user = repository.getReferenceById(id);
        user.setStatus("DISABLED");
        repository.save(user);
    }

    @Override
    public User update(User user) {
        return repository.save(user);
    }
}
