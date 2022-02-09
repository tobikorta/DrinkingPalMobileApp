package com.ts.tk.drinkingpalmobileapp.activities;

import android.os.Bundle;

import com.ts.tk.drinkingpalmobileapp.R;

import java.util.Objects;

public class StatsHistory extends SupportExtensions {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats_history);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Stats / History");
        upArrow();
    }
}
