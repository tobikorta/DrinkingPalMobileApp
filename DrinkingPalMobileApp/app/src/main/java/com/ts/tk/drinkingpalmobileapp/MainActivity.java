package com.ts.tk.drinkingpalmobileapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends SupportExtensions {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_app_opening);

        Button buttonOpenSignUpPage = findViewById(R.id.btnContinueToSignUpPage);
        Button buttonContinueWithGoogle = findViewById(R.id.btnContinueWithGoogle);

        buttonOpenSignUpPage.setOnClickListener(view -> openSignUpPage());

        buttonContinueWithGoogle.setOnClickListener(view -> {

        });
    }
}