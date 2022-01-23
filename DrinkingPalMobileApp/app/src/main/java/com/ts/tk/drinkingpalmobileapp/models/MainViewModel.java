package com.ts.tk.drinkingpalmobileapp.models;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private UserRepository repository;
    private LiveData<List<User>> allUsers;
    private MutableLiveData<List<User>> searchResults;

    public MainViewModel(Application application){
        super(application);
        repository = new UserRepository(application);
        allUsers = repository.getAllUsers();
        searchResults = repository.getSearchResults();
    }
    MutableLiveData<List<User>> getSearchResults(){
        return searchResults;
    }

    LiveData<List<User>> getAllUsers(){
        return allUsers;
    }
}
