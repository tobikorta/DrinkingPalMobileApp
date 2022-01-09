package com.ts.tk.drinkingpalmobileapp.models;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DrinkingEvent {

    private Long id;
    private User creator;
    private LocalDateTime date;
    private Location location;

    @Builder
    public DrinkingEvent(Long id, User creator, LocalDateTime date, Location location) {
        this.id = id;
        this.creator = creator;
        this.date = date;
        this.location = location;
    }
}
