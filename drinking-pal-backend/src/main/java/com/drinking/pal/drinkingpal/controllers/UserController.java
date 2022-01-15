package com.drinking.pal.drinkingpal.controllers;

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

    @PostMapping
    public ResponseEntity<?> createAccount(@RequestBody User user) {
        userService.createAccount(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
