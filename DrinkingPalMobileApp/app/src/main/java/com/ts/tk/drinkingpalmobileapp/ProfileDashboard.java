package com.ts.tk.drinkingpalmobileapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class ProfileDashboard extends SupportExtensions {

    private TextView textFullName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_dashboard);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Profile Dashboard");

        Button buttonContinueToEvents = findViewById(R.id.btnEvents);
        Button buttonContinueToMessages = findViewById(R.id.btnMessages);
        Button buttonContinueToFavouriteBars = findViewById(R.id.btnFavouriteBars);
        Button buttonContinueToStatsHistory = findViewById(R.id.btnStatsHistory);
        Button buttonContinueToProfileEdit = findViewById(R.id.btnProfileEdit);

        buttonContinueToEvents.setOnClickListener(view -> {
            openEvents();
        });
        buttonContinueToMessages.setOnClickListener(view -> {
            openMessages();
        });
        buttonContinueToFavouriteBars.setOnClickListener(view -> {
            openFavouriteBars();
        });
        buttonContinueToStatsHistory.setOnClickListener(view -> {
            openStatsHistory();
        });
        buttonContinueToProfileEdit.setOnClickListener(view -> {
            openProfileEdit();
        });

    }

}