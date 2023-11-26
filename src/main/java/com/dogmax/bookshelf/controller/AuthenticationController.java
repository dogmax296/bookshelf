package com.dogmax.bookshelf.controller;

import com.dogmax.bookshelf.dto.UserLoginDto;
import com.dogmax.bookshelf.model.Role;
import com.dogmax.bookshelf.model.User;
import com.dogmax.bookshelf.security.AuthenticationService;
import com.dogmax.bookshelf.security.jwt.JwtTokenProvider;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthenticationController(AuthenticationService authenticationService,
                                    JwtTokenProvider jwtTokenProvider) {
        this.authenticationService = authenticationService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid UserLoginDto userLoginDto) {
        User user = authenticationService
                .login(userLoginDto.getLogin(), userLoginDto.getPassword());
        String token = jwtTokenProvider
                .createToken(user.getLogin(), user.getRoles().stream().map(Role::getRole).collect(Collectors.toList()));
        return new ResponseEntity<>(Map.of("token", token,"user_id", user.getId(),"roles",user.getRoles()), HttpStatus.OK);
    }

}
