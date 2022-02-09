package com.drinking.pal.drinkingpal.service;

import com.drinking.pal.drinkingpal.config.security.CurrentUser;
import com.drinking.pal.drinkingpal.entities.Event;
import com.drinking.pal.drinkingpal.entities.User;
import com.drinking.pal.drinkingpal.exceptions.NotFoundException;
import com.drinking.pal.drinkingpal.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository repository;
    private final CurrentUser currentUser;

    @Transactional
    public void saveEvent(Event event) {
        event.setCreator(currentUser.get());
        repository.save(event);
    }

    @Transactional
    public void joinEvent(Long eventId) {
        User currentUser = this.currentUser.get();
        Event event = repository.findById(eventId).orElseThrow(() -> new NotFoundException("No Event found under id : " + eventId));
        event.getJoiners().add(currentUser);
    }

    public Event getEventDetails(Long eventId) {
        return repository.findById(eventId).orElseThrow(() -> new NotFoundException("No Event found under id : " + eventId));
    }

    public List<Event> getAllUpcomingEvents() {
        return repository.findAll();
    }
}
