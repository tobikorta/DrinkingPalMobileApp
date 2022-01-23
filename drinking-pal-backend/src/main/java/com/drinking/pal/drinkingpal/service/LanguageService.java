package com.drinking.pal.drinkingpal.service;

import com.drinking.pal.drinkingpal.entities.Language;
import com.drinking.pal.drinkingpal.repository.LanguageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LanguageService {

    private final LanguageRepository repository;

    public List<Language> getAllLanguages() {
        return repository.findAll();
    }
}
