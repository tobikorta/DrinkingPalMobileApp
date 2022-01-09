package com.ts.tk.drinkingpalmobileapp;

import android.os.Bundle;

import java.util.Objects;

public class Events extends SupportExtensions{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Events");
        upArrow();


    }
}
