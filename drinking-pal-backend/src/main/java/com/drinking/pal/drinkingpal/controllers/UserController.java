package com.drinking.pal.drinkingpal.controllers;

import com.drinking.pal.drinkingpal.config.security.JwtTokenProvider;
import com.drinking.pal.drinkingpal.dto.Value;
import com.drinking.pal.drinkingpal.entities.User;
import com.drinking.pal.drinkingpal.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final JwtTokenProvider tokenProvider;

    @PostMapping
    public ResponseEntity<?> createAccount(@RequestBody User user) {
        userService.createAccount(user);
        String token = tokenProvider.createToken(user.getEmail(), user.getRole());
        return new ResponseEntity<>(new Value<>(token), HttpStatus.CREATED);
    }
}
