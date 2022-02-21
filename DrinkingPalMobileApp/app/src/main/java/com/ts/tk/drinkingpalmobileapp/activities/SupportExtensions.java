package com.ts.tk.drinkingpalmobileapp.activities;
/*
    Database docu AndroidStudio
    https://developer.android.com/training/data-storage/room#java
    INTENTS
    VOLLEY
 */
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AppCompatActivity;

import com.ts.tk.drinkingpalmobileapp.activities.ChooseLanguagePage;
import com.ts.tk.drinkingpalmobileapp.activities.Events;
import com.ts.tk.drinkingpalmobileapp.activities.FavouriteBars;
import com.ts.tk.drinkingpalmobileapp.activities.HomeScreen;
import com.ts.tk.drinkingpalmobileapp.activities.Messages;
import com.ts.tk.drinkingpalmobileapp.activities.ProfileDashboard;
import com.ts.tk.drinkingpalmobileapp.activities.ProfileEdit;
import com.ts.tk.drinkingpalmobileapp.activities.SignUpPage;
import com.ts.tk.drinkingpalmobileapp.activities.StatsHistory;

public class SupportExtensions extends AppCompatActivity {

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

    public void openSignUpPage() {
        Intent intentOpenSignUpPage = new Intent(this, SignUpPage.class);
        startActivity(intentOpenSignUpPage);
    }

    public void openSignInPage() {
        Intent intentOpenSignInPage = new Intent(this, SignInPage.class);
        startActivity(intentOpenSignInPage);
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

    public void openHomeScreen(String email, String password) {
        Intent intentOpenHomeScreen = new Intent(this, HomeScreen.class);
        intentOpenHomeScreen
                .putExtra("EMAIL", email)
                .putExtra("PASSWORD", password);
        startActivity(intentOpenHomeScreen);
    }

    public void openProfileDashboard() {
        Intent intentOpenProfileDashboard = new Intent(this, ProfileDashboard.class);
        startActivity(intentOpenProfileDashboard);
    }

    public void openEvents(){
        Intent intentOpenEvents = new Intent(this, Events.class);
        startActivity(intentOpenEvents);
    }

    public void openMessages(){
        Intent intentOpenMessages = new Intent(this, Messages.class);
        startActivity(intentOpenMessages);
    }

    public void openFavouriteBars(){
        Intent intentOpenFavouriteBars = new Intent(this, FavouriteBars.class);
        startActivity(intentOpenFavouriteBars);
    }

    public void openStatsHistory(){
        Intent intentOpenStatsHistory = new Intent(this, StatsHistory.class);
        startActivity(intentOpenStatsHistory);
    }

    public void openProfileEdit(){
        Intent intentOpenProfileEdit = new Intent(this, ProfileEdit.class);
        startActivity(intentOpenProfileEdit);
    }

    public void openNewEvent(){
        Intent intentOpenNewEvent = new Intent(this, NewEvent.class);
        startActivity(intentOpenNewEvent);
    }

}

