package com.drinking.pal.drinkingpal.controllers;

import com.drinking.pal.drinkingpal.entities.Bar;
import com.drinking.pal.drinkingpal.service.BarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bars")
@RequiredArgsConstructor
public class BarController {

    private final BarService barService;

    @GetMapping
    public ResponseEntity<List<Bar>> getAllBars() {
        return new ResponseEntity<>(barService.getAllBars(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bar> getBarById(@PathVariable("id") Long barId) {
        return new ResponseEntity<>(barService.getById(barId), HttpStatus.OK);
    }
}
