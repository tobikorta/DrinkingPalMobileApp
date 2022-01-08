package com.ts.tk.drinkingpalmobileapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AppCompatActivity;

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

    public void openChooseLanguagePage() {
        Intent intentOpenChooseLanguagePage = new Intent(this, ChooseLanguagePage.class);
        startActivity(intentOpenChooseLanguagePage);
    }

    public void openHomeScreen() {
        Intent intentOpenHomeScreen = new Intent(this, HomeScreen.class);
        startActivity(intentOpenHomeScreen);
    }

}

