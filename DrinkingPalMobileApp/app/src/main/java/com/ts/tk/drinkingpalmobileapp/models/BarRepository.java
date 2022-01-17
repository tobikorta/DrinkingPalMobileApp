package com.ts.tk.drinkingpalmobileapp.models;

import android.app.Application;
import android.graphics.LightingColorFilter;
import android.os.Looper;
import android.os.Message;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ts.tk.drinkingpalmobileapp.Messages;

import java.util.List;
import java.util.logging.Handler;

public class BarRepository {
    private final MutableLiveData<List<DrinkingEvent>> bars = new MutableLiveData<>();
    private List<DrinkingEvent> results;
    private final LiveData<List<DrinkingEvent>> allDrinkingEvents;
    private final DrinkingEventDao drinkingEventDao;

    Handler handler = new Handler(Looper.getMainLooper()){
        @Override
        public void handlerMessage(Message msg){
            bars.setValue(results);
        }
    };
    public BarRepository (Application application){
        AppDatabase db;
        db = AppDatabase.getDatabase(application);
        drinkingEventDao = db.drinkingEventDao();
        allDrinkingEvents = drinkingEventDao.getAllDrinkingEvents();
    }

    
}
