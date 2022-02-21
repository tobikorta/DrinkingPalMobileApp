package com.ts.tk.drinkingpalmobileapp.activities;

import android.os.Bundle;
import android.widget.Button;

import com.ts.tk.drinkingpalmobileapp.R;
import com.ts.tk.drinkingpalmobileapp.restServices.LanguageService;


public class MainActivity extends SupportExtensions {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_app_opening);

        Button buttonOpenSignUpPage = findViewById(R.id.btnContinueToSignUpPage);
        Button buttonContinueWithGoogle = findViewById(R.id.btnContinueWithGoogle);
        Button buttonAlreadyHaveAccount = findViewById(R.id.btnAlreadyHaveAccount);

        buttonOpenSignUpPage.setOnClickListener(view -> openSignUpPage());

        buttonContinueWithGoogle.setOnClickListener(view -> {

        });

        buttonAlreadyHaveAccount.setOnClickListener(view -> openSignInPage());

        try {
           // UserService.getInstance(this).createUserAccount(UserDto.builder().lastName("Korta").email("tobikorta2@gmail.com").firstName("Tobi").build());

            LanguageService.getInstance(this).getAllLanguages();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}