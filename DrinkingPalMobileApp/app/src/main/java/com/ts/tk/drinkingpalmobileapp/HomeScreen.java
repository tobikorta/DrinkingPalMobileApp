package com.ts.tk.drinkingpalmobileapp;

import android.os.Bundle;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

public class HomeScreen extends SupportExtensions {

    private Button buttonSearch;
    RecyclerView recyclerView;

    String s1[], s2[];
    int images[] = {R.drawable.bildMvvParis};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        Objects.requireNonNull(getSupportActionBar()).setTitle("HomeScreen");

        Button buttonContinueToDashboard = findViewById(R.id.btnProfileDashboard);
        buttonContinueToDashboard.setOnClickListener(view -> {

            openProfileDashboard();
        });

        recyclerView = findViewById(R.id.recViewHomeScreen);

        s1 = getResources().getStringArray(R.array.title_bar);
        s2 = getResources().getStringArray(R.array.description);

        RecViewBarsAdapter recViewBarsAdapter = new RecViewBarsAdapter(this, s1, s2, images);
        recyclerView.setAdapter(recViewBarsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


}