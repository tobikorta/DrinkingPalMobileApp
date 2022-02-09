package com.ts.tk.drinkingpalmobileapp.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.ts.tk.drinkingpalmobileapp.R;

import java.util.Objects;

public class SignUpPage extends SupportExtensions {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_page);


        Objects.requireNonNull(getSupportActionBar()).setTitle("SignUpPage");
        upArrow();

        EditText inputFirstName = findViewById(R.id.inputFirstName);
        String firstName = inputFirstName.getText().toString();
        EditText inputLastName = findViewById(R.id.inputLastName);
        String lastName = inputLastName.getText().toString();
        EditText inputEmail = findViewById(R.id.inputEmail);
        String email = inputEmail.getText().toString();
        EditText inputPassword = findViewById(R.id.inputPassword);
        String password = inputPassword.getText().toString();

        Button buttonContinueToChooseLanguage = findViewById(R.id.btnContinueToChooseLanguage);
        buttonContinueToChooseLanguage.setOnClickListener(view -> {

            openChooseLanguagePage(firstName, lastName, email, password);
            autoKeyboardRemover();
        });


    }


}