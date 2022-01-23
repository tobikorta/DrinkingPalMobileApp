package com.ts.tk.drinkingpalmobileapp.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity(tableName = "User")
public class User {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name ="user_id")
    public int id;

    @ColumnInfo(name = "username")
    public String username;

    public User(String username){
        this.username = username;
    }
}
