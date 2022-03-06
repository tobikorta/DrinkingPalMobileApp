package com.drinking.pal.drinkingpal.service;

import com.drinking.pal.drinkingpal.entities.Bar;
import com.drinking.pal.drinkingpal.exceptions.NotFoundException;
import com.drinking.pal.drinkingpal.repository.BarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BarService {

    private final BarRepository repository;

    @PostConstruct
    void initializeData() {
        if (repository.findAll().isEmpty()) {
            repository.save(Bar.builder().name("True Brew Brewing Co").description("Bar Descrption").latitude(48.1288588).longitude(11.5421585).build());
            repository.save(Bar.builder().name("Bar 2").description("Bar Descrption").longitude(48.1288588).latitude(11.5421585).build());
            repository.save(Bar.builder().name("Bar 3").description("Bar Descrption").latitude(48.1288588).longitude(11.5421585).build());
            repository.save(Bar.builder().name("Bar 4").description("Bar Descrption").latitude(48.1288588).longitude(11.5421585).build());
            repository.save(Bar.builder().name("Bar 5").description("Bar Descrption").latitude(48.1288588).longitude(11.5421585).build());
            repository.save(Bar.builder().name("Bar 6").description("Bar Descrption").latitude(48.1288588).longitude(11.5421585).build());
            repository.save(Bar.builder().name("Bar 7").description("Bar Descrption").latitude(48.1288588).longitude(11.5421585).build());
            repository.save(Bar.builder().name("Bar 8").description("Bar Descrption").latitude(48.1288588).longitude(11.5421585).build());
            repository.save(Bar.builder().name("Bar 9").description("Bar Descrption").latitude(48.1288588).longitude(11.5421585).build());
        }
    }

    public List<Bar> getAllBars() {
        return repository.findAll();
    }

    @Transactional
    public void saveBar(Bar bar) {
        repository.save(bar);
    }

    public Bar getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("No Bar found under Id " + id));
    }
}
