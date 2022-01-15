package com.drinking.pal.drinkingpal.repository;

import com.drinking.pal.drinkingpal.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
