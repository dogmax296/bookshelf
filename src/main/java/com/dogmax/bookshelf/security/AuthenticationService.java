package com.dogmax.bookshelf.security;


import com.dogmax.bookshelf.model.User;

public interface AuthenticationService {

    User login(String login, String password);
}
