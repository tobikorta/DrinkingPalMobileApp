package com.ts.tk.drinkingpalmobileapp.models;

import android.app.Application;
import android.os.Looper;
import android.os.Message;
import android.os.Handler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserRepository {
    private final MutableLiveData<List<User>> users = new MutableLiveData<>();
    private List<User> results;
    private final LiveData<List<User>> allUsers;
    private final DrinkingEventDao drinkingEventDao;

    Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg){
            users.setValue(results);
        }
    };

    public UserRepository(Application application){
        AppRoomDatabase db;
        db = AppRoomDatabase.getDatabase(application);
        drinkingEventDao = db.drinkingEventDao();
        allUsers = drinkingEventDao.getAll();
    }
    public void findUser(String name)
    {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            results = drinkingEventDao.findUser(name);
            handler.sendEmptyMessage(0);
        });
        executor.shutdown();
    }

    public LiveData<List<User>> getAllUsers(){
        return allUsers;
    }

    public MutableLiveData<List<User>> getSearchResults(){
        return users;
    }
}
