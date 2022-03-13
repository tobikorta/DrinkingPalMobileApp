package com.ts.tk.drinkingpalmobileapp.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import com.ts.tk.drinkingpalmobileapp.R;
import com.ts.tk.drinkingpalmobileapp.restServices.Constants;
import com.ts.tk.drinkingpalmobileapp.restServices.LanguageService;
import com.ts.tk.drinkingpalmobileapp.support.SupportExtensions;


public class MainActivity extends SupportExtensions {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_app_opening);

        SharedPreferences sharedPref = getSharedPreferences(
                Constants.SHARED_PREFS_KEY, Context.MODE_PRIVATE);
        if (sharedPref.contains("jwt")) {
            openActivity(HomeScreen.class);
        }

        Button buttonOpenSignUpPage = findViewById(R.id.btnContinueToSignUpPage);
        Button buttonAlreadyHaveAccount = findViewById(R.id.btnAlreadyHaveAccount);

        buttonOpenSignUpPage.setOnClickListener(view -> openActivity(SignUpPage.class));

        buttonAlreadyHaveAccount.setOnClickListener(view -> openActivity(HomeScreen.class));

        try {
           // UserService.getInstance(this).createUserAccount(UserDto.builder().lastName("Korta").email("tobikorta2@gmail.com").firstName("Tobi").build());

            LanguageService.getInstance(this).getAllLanguages();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}