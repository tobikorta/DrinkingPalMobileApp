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
        EditText inputLastName = findViewById(R.id.inputLastName);
        EditText inputEmail = findViewById(R.id.inputEmail);
        EditText inputPassword = findViewById(R.id.inputPassword);

        Button buttonContinueToChooseLanguage = findViewById(R.id.btnContinueToChooseLanguage);
        buttonContinueToChooseLanguage.setOnClickListener(view -> {
            String firstName = inputFirstName.getText().toString();
            String lastName = inputLastName.getText().toString();
            String email = inputEmail.getText().toString();
            String password = inputPassword.getText().toString();

            openChooseLanguagePage(firstName, lastName, email, password);
            autoKeyboardRemover();
        });

    }

}