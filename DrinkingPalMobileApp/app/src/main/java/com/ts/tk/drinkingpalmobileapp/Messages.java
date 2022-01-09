package com.ts.tk.drinkingpalmobileapp;

import android.os.Bundle;

import java.util.Objects;

public class Messages extends SupportExtensions{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messages);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Messages");
        upArrow();
    }
}
