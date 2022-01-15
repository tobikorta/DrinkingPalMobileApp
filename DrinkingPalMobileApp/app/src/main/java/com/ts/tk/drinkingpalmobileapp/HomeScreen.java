package com.ts.tk.drinkingpalmobileapp;

import android.os.Bundle;
import android.widget.Button;

import java.util.Objects;

public class HomeScreen extends SupportExtensions {

    private Button buttonSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        Objects.requireNonNull(getSupportActionBar()).setTitle("HomeScreen");

        Button buttonContinueToDashboard = findViewById(R.id.btnProfileDashboard);
        buttonContinueToDashboard.setOnClickListener(view -> {

            openProfileDashboard();
        });



    }


}