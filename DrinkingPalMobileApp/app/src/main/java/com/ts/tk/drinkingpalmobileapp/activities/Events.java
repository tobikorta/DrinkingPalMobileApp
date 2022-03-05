package com.ts.tk.drinkingpalmobileapp.activities;

import android.os.Bundle;

import com.ts.tk.drinkingpalmobileapp.R;
import com.ts.tk.drinkingpalmobileapp.support.SupportExtensions;

import java.util.Objects;

public class Events extends SupportExtensions {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Events");
        upArrow();


    }
}
