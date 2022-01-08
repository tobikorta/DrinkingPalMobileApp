package com.ts.tk.drinkingpalmobileapp;

import android.os.Bundle;

public class HomeScreen extends SupportExtensions {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        getSupportActionBar().setTitle("HomeScreen");

    }

}