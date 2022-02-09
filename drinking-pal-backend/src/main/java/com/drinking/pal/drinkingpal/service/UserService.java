package com.drinking.pal.drinkingpal.service;

import com.drinking.pal.drinkingpal.entities.User;
import com.drinking.pal.drinkingpal.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    private final PasswordEncoder encoder;

    @Transactional
    public void createAccount(User user) {
        user.setSubscriptionType(User.SubscriptionType.MANUAL);
        user.setStatus(User.AccountState.VALIDATED);
        user.setRole(User.Role.USER);
        user.setPassword(encoder.encode(user.getPassword()));
        repository.save(user);
    }
}
