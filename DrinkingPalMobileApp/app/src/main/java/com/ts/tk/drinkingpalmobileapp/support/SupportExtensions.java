package com.ts.tk.drinkingpalmobileapp.support;
/*
    Database docu AndroidStudio
    https://developer.android.com/training/data-storage/room#java
    INTENTS
    VOLLEY
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AppCompatActivity;

import com.ts.tk.drinkingpalmobileapp.activities.ChooseLanguagePage;
import com.ts.tk.drinkingpalmobileapp.activities.HomeScreen;


import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SupportExtensions extends AppCompatActivity {

    private static final Map<String, String> emptyMap = Collections.emptyMap();

    public void autoKeyboardRemover(){
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void upArrow(){
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void openChooseLanguagePage(String fName, String lName, String email, String password) {
        Intent intentOpenChooseLanguagePage = new Intent(this, ChooseLanguagePage.class);
        intentOpenChooseLanguagePage
                .putExtra("FNAME", fName)
                .putExtra("LNAME", lName)
                .putExtra("EMAIL", email)
                .putExtra("PASSWORD", password);
        startActivity(intentOpenChooseLanguagePage);
    }

    public void openActivity(Class<? extends SupportExtensions> activityClass) {
        openActivity(activityClass, emptyMap);
    }

    public void openActivity(Class<? extends SupportExtensions> activityClass, Map<String, ? extends Serializable> extras) {
        Intent intent = new Intent(this, activityClass);
        for (String key : extras.keySet()) {
            intent.putExtra(key, extras.get(key));
        }
        startActivity(intent);
    }

    public void openHomeScreen(String email, String password) {
        Intent intentOpenHomeScreen = new Intent(this, HomeScreen.class);
        intentOpenHomeScreen
                .putExtra("EMAIL", email)
                .putExtra("PASSWORD", password);
        startActivity(intentOpenHomeScreen);
    }
}

