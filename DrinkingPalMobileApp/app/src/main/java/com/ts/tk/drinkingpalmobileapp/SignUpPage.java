package com.ts.tk.drinkingpalmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class SignUpPage extends AppCompatActivity {

    private Button buttonContinueToChooseLanguage;
    EditText inputFirstName;
    EditText inputLastName;
    EditText inputEmail;
    EditText inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_page);

        buttonContinueToChooseLanguage = findViewById(R.id.btnContinueToChooseLanguage);
        buttonContinueToChooseLanguage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                openChooseLanguagePage();
                autoKeyboardRemover();
            }
        });
    }

    private void openChooseLanguagePage() {
        Intent intentOpenChooseLanguagePage = new Intent(this, ChooseLanguagePage.class);
        startActivity(intentOpenChooseLanguagePage);
    }
    private void autoKeyboardRemover(){

        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}