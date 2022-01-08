package com.ts.tk.drinkingpalmobileapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SignUpPage extends SupportExtensions {

    private Button buttonContinueToChooseLanguage;

    EditText inputFirstName;
    EditText inputLastName;
    EditText inputEmail;
    EditText inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_page);


        getSupportActionBar().setTitle("SignUpPage");
        upArrow();

        buttonContinueToChooseLanguage = findViewById(R.id.btnContinueToChooseLanguage);
        buttonContinueToChooseLanguage.setOnClickListener(view -> {

            openChooseLanguagePage();
            autoKeyboardRemover();
        });


    }


}