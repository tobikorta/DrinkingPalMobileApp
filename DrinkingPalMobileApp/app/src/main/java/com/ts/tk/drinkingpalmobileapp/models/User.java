package com.ts.tk.drinkingpalmobileapp.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity

public class User {

    @PrimaryKey
    private int id;

    @ColumnInfo(name = "Name")
    private String name;

    @Builder
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
