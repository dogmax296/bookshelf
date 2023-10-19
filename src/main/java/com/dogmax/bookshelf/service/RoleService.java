package com.dogmax.bookshelf.service;


import com.dogmax.bookshelf.model.Role;

import java.util.List;

public interface RoleService {

    Role create(Role role);

    Role getById(Long id);

    List<Role> findAll();
}
