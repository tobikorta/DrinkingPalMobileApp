package com.ts.tk.drinkingpalmobileapp.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DummyDataGenerator {

    public static List<DrinkingEvent> generateEvents() {
        List<DrinkingEvent> drinkingEvents = new ArrayList<>();
        drinkingEvents.add(new DrinkingEvent.DrinkingEventBuilder()
                .date(LocalDateTime.of(2022, 1,10, 18, 0, 0))
                .creator(new User.UserBuilder().id(1L).name("Tobi").build())
                .location(new Location.LocationBuilder().address("Schachblumenweg").name("Puzzles").id(1L).build())
                .build());

        drinkingEvents.add(new DrinkingEvent.DrinkingEventBuilder()
                .date(LocalDateTime.of(2021, 2,11, 19, 0, 0))
                .creator(new User.UserBuilder().id(2L).name("Joseph").build())
                .location(new Location.LocationBuilder().address("Kaufingerstraße").name("TrueBrew").id(2L).build())
                .build());

        drinkingEvents.add(new DrinkingEvent.DrinkingEventBuilder()
                .date(LocalDateTime.of(2020, 3,12, 20, 0, 0))
                .creator(new User.UserBuilder().id(3L).name("Eneko").build())
                .location(new Location.LocationBuilder().address("Riedstraße").name("Kennedys").id(3L).build())
                .build());

        drinkingEvents.add(new DrinkingEvent.DrinkingEventBuilder()
                .date(LocalDateTime.of(2019, 4,13, 21, 0, 0))
                .creator(new User.UserBuilder().id(4L).name("Flo").build())
                .location(new Location.LocationBuilder().address("Münchenerstraße").name("Hoppers").id(4L).build())
                .build());

        drinkingEvents.add(new DrinkingEvent.DrinkingEventBuilder()
                .date(LocalDateTime.of(2018, 5,14, 22, 0, 0))
                .creator(new User.UserBuilder().id(5L).name("Annelie").build())
                .location(new Location.LocationBuilder().address("Berlinerstraße").name("Cafée").id(5L).build())
                .build());

        return drinkingEvents;
    }
}
