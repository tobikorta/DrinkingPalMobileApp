package com.drinking.pal.drinkingpal.repository;

import com.drinking.pal.drinkingpal.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("select e from Event e join fetch e.bar b join fetch e.creator c where e.date > current_timestamp ")
    List<Event> findUpcomingEvent();
}
