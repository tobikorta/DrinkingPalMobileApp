package com.ts.tk.drinkingpalmobileapp.models;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DrinkingEventDao {
    @Query("SELECT * FROM DrinkingEvent")
    List<DrinkingEvent> getAll();
}
