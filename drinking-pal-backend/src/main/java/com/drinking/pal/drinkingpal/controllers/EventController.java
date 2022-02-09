package com.drinking.pal.drinkingpal.controllers;

import com.drinking.pal.drinkingpal.entities.Event;
import com.drinking.pal.drinkingpal.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        return new ResponseEntity<>(eventService.getAllUpcomingEvents(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventByUId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(eventService.getEventDetails(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createEvent(@RequestBody Event event) {
        eventService.saveEvent(event);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/join/{id}")
    public ResponseEntity<?> joinEvent(@PathVariable("id") Long id) {
        eventService.joinEvent(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
