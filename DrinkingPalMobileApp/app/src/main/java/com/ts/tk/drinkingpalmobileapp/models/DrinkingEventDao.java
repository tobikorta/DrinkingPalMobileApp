package com.ts.tk.drinkingpalmobileapp.models;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DrinkingEventDao {
    @Query("SELECT * FROM user")
    LiveData<List<User>> getAll();

    @Query("select * from user where username = :name")
    List<User> findUser(String name);
}
