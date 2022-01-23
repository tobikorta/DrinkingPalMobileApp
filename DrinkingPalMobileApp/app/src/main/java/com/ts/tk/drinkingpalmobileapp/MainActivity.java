package com.ts.tk.drinkingpalmobileapp;

import android.os.Bundle;
import android.widget.Button;

import com.ts.tk.drinkingpalmobileapp.dtos.UserDto;
import com.ts.tk.drinkingpalmobileapp.restServices.LanguageService;
import com.ts.tk.drinkingpalmobileapp.restServices.UserService;


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

        try {
           // UserService.getInstance(this).createUserAccount(UserDto.builder().lastName("Korta").email("tobikorta2@gmail.com").firstName("Tobi").build());

            LanguageService.getInstance(this).getAllLanguages();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}