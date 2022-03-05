package com.ts.tk.drinkingpalmobileapp.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.ts.tk.drinkingpalmobileapp.R;
import com.ts.tk.drinkingpalmobileapp.support.SupportExtensions;

import java.util.Objects;

public class SignInPage extends SupportExtensions {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_page);


        Objects.requireNonNull(getSupportActionBar()).setTitle("SignInPage");
        upArrow();

        EditText inputEmail = findViewById(R.id.inputUsername);
        EditText inputPassword = findViewById(R.id.inputPassword);

        Button buttonContinueToChooseLanguage = findViewById(R.id.btnContinueToChooseLanguage);
        buttonContinueToChooseLanguage.setOnClickListener(view -> {

            String email = inputEmail.getText().toString();
            String password = inputPassword.getText().toString();

            openHomeScreen(email, password);
            autoKeyboardRemover();
        });

    }

}