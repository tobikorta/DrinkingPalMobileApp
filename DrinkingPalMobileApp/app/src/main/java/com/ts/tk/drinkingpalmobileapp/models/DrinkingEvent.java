package com.ts.tk.drinkingpalmobileapp.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity

public class DrinkingEvent {

    @PrimaryKey
    private int id;

    @ColumnInfo(name = "creator")
    private User name;

    @ColumnInfo(name = "date")
    private LocalDateTime date;

    @ColumnInfo(name = "location")
    private Location location;

    @Builder
    public DrinkingEvent(int id, User name, LocalDateTime date, Location location) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.location = location;
    }
}
