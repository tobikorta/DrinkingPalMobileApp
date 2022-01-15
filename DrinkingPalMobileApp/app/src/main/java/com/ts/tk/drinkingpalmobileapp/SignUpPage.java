package com.ts.tk.drinkingpalmobileapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

public class SignUpPage extends SupportExtensions {

    EditText inputFirstName;
    EditText inputLastName;
    EditText inputEmail;
    EditText inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_page);


        Objects.requireNonNull(getSupportActionBar()).setTitle("SignUpPage");
        upArrow();

        Button buttonContinueToChooseLanguage = findViewById(R.id.btnContinueToChooseLanguage);
        buttonContinueToChooseLanguage.setOnClickListener(view -> {

            openChooseLanguagePage();
            autoKeyboardRemover();
        });


    }


}