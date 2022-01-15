package com.ts.tk.drinkingpalmobileapp.models;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {DrinkingEvent.class, User.class, Location.class}, version =1)
public abstract class AppDatabase extends RoomDatabase{
    private static AppDatabase appDatabase = null;
    public abstract DrinkingEventDao drinkingEventDao();
    static AppDatabase getDatabase(final Context context){
        if (appDatabase == null){
            synchronized (AppDatabase.class){
             if (appDatabase == null){
                 appDatabase = Room.databaseBuilder(context.getApplicationContext(),
                         AppDatabase.class, "Database 1").build();
             }
            }

        }
        return appDatabase;
    }
}
