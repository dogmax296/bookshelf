package com.dogmax.bookshelf.service;


import com.dogmax.bookshelf.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User create(User user);

    List<User> findAll();

    User getById(Long id);

    void delete(Long id);

    User update(User user);

    Optional<User> findByEmail(String email);
}
