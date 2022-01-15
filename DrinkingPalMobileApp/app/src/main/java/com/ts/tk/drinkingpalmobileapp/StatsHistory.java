package com.ts.tk.drinkingpalmobileapp;

import android.os.Bundle;

import java.util.Objects;

public class StatsHistory extends SupportExtensions{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats_history);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Stats / History");
        upArrow();
    }
}
