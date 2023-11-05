package com.dogmax.bookshelf.service.impl;

import com.dogmax.bookshelf.model.User;
import com.dogmax.bookshelf.repository.RoleRepository;
import com.dogmax.bookshelf.repository.UserRepository;
import com.dogmax.bookshelf.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Value("${admin.login}")
    private String login;
    @Value("${admin.password}")
    private String password;
    @Value("${admin.role}")
    private List<String> roles;

    public UserServiceImpl(UserRepository repository,
                           RoleRepository roleRepository) {
        this.userRepository = repository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.getReferenceById(id);
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.getReferenceById(id);
        user.setStatus("DISABLED");
        userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<User> result;
        if (email.equalsIgnoreCase(login)) {
            User user = new User();
            user.setId(1000L);
            user.setLogin(login);
            user.setPassword(password);
            user.setRoles(roles.stream().map(roleRepository::findByRole).filter(Optional::isPresent).map(Optional::get).collect(Collectors.toList()));
            result = Optional.of(user);
        } else {
            result = userRepository.findUserByLogin(email);
        }
        return result;
    }
}
