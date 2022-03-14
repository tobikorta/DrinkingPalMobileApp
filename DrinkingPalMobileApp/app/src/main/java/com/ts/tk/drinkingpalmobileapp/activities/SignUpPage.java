package com.ts.tk.drinkingpalmobileapp.activities;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.constraintlayout.widget.ConstraintLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ts.tk.drinkingpalmobileapp.R;
import com.ts.tk.drinkingpalmobileapp.support.SupportExtensions;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

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

            ;

            openChooseLanguagePage(firstName, lastName, email, password);
//            openActivity(ChooseLanguagePage.class, new Map<String, Serializable> (firstName+ lastName + email + password));
            autoKeyboardRemover();
        });

        ConstraintLayout layout = findViewById(R.id.signUpPageContainer);
        layout.setOnClickListener(v -> {
            autoKeyboardRemover();

        });

    }
}