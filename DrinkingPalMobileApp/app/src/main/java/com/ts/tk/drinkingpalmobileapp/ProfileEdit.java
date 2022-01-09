package com.ts.tk.drinkingpalmobileapp;

import android.os.Bundle;

import java.util.Objects;

public class ProfileEdit extends SupportExtensions{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_edit);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Edit Profile");
        upArrow();
    }
}
