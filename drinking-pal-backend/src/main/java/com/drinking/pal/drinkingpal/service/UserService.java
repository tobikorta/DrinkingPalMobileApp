package com.drinking.pal.drinkingpal.service;

import com.drinking.pal.drinkingpal.entities.User;
import com.drinking.pal.drinkingpal.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    @Transactional
    public void createAccount(User user) {
        repository.save(user);
    }
}
