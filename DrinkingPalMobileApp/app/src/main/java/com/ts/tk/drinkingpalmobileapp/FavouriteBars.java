package com.ts.tk.drinkingpalmobileapp;

import android.os.Bundle;

import java.util.Objects;

public class FavouriteBars extends SupportExtensions{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favourite_bars);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Favourite Bars");
        upArrow();
    }
}