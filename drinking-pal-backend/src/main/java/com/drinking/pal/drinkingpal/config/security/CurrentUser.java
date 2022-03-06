package com.drinking.pal.drinkingpal.config.security;


import com.drinking.pal.drinkingpal.entities.User;
import com.drinking.pal.drinkingpal.exceptions.NotFoundException;
import com.drinking.pal.drinkingpal.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
@RequiredArgsConstructor
public class CurrentUser {

    private User user;
    private final UserRepository userRepository;

    public User get() {
        if (user == null) {
            org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            this.user = userRepository.findByEmail(principal.getUsername())
                    .orElseThrow(() -> new NotFoundException("No User found under username " + principal.getUsername()));
        }
        return user;
    }


}
