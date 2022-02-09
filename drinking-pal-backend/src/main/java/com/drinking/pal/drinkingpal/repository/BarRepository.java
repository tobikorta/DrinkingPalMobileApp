package com.drinking.pal.drinkingpal.repository;

import com.drinking.pal.drinkingpal.entities.Bar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarRepository extends JpaRepository<Bar, Long> {
}
