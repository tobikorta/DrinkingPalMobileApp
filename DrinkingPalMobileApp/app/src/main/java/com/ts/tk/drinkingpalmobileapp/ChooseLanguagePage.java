package com.ts.tk.drinkingpalmobileapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Objects;

public class ChooseLanguagePage extends SupportExtensions
        implements AdapterView.OnItemSelectedListener {

    private Spinner spnSearchForLanguage;

    private String chooseFirstLanguage;
    private String chooseSecondLanguage;
    private String chooseThirdLanguage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_language_page);


        Objects.requireNonNull(getSupportActionBar()).setTitle("ChooseLanguage");
        upArrow();

        Button buttonContinueToHomeScreen = findViewById(R.id.btnContinueToHomeScreen);
        buttonContinueToHomeScreen.setOnClickListener(view -> {

            openHomeScreen();
            autoKeyboardRemover();
        });

        Spinner spinnerOne = (Spinner) findViewById(R.id.spnSearchForLanguageOne);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.chooseLanguageSpinner, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerOne.setAdapter(adapter);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapter, View view, int position, long id) {

        chooseFirstLanguage = spnSearchForLanguage.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}


