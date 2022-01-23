package com.drinking.pal.drinkingpal.controllers;

import com.drinking.pal.drinkingpal.entities.Language;
import com.drinking.pal.drinkingpal.service.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/languages")
@RequiredArgsConstructor
public class LanguageController {

    private final LanguageService languageService;

    @GetMapping
    public ResponseEntity<List<Language>> getAllLanguages() {
        return new ResponseEntity<>(languageService.getAllLanguages(), HttpStatus.OK);
    }
}
