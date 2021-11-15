package com.ts.tk.drinkingpalmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

private Button buttonOpenSignUpPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_app_opening);

        buttonOpenSignUpPage = findViewById(R.id.btnContinueToSignUpPage);
        buttonOpenSignUpPage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                openSignUpPage();
            }
        });
    }

    private void openSignUpPage() {
        Intent intentOpenSignUpPage = new Intent(this, SignUpPage.class);
        startActivity(intentOpenSignUpPage);
    }
}