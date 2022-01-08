package com.ts.tk.drinkingpalmobileapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class ChooseLanguagePage extends SupportExtensions
        implements AdapterView.OnItemSelectedListener {

    private Spinner spnSearchForLanguageOne;
    private Spinner spnSearchForLanguageTwo;
    private Spinner spnSearchForLanguageThree;

    private Button buttonContinueToHomeScreen;

    private String chooseFirstLanguage;
    private String chooseSecondLanguage;
    private String chooseThirdLanguage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_language_page);


        getSupportActionBar().setTitle("ChooseLanguage");
        upArrow();

        buttonContinueToHomeScreen = findViewById(R.id.btnContinueToHomeScreen);
        buttonContinueToHomeScreen.setOnClickListener(view -> {

            openHomeScreen();
            autoKeyboardRemover();
        });

        Spinner spinnerOne = (Spinner) findViewById(R.id.spnSearchForLanguageOne);
        Spinner spinnerTwo = (Spinner) findViewById(R.id.spnSearchForLanguageTwo);
        Spinner spinnerThree = (Spinner) findViewById(R.id.spnSearchForLanguageThree);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.chooseLanguageSpinner, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerOne.setAdapter(adapter);
        spinnerTwo.setAdapter(adapter);
        spinnerThree.setAdapter(adapter);


    }


    @Override
    public void onItemSelected(AdapterView<?> adapter, View view, int position, long id) {

        chooseFirstLanguage = spnSearchForLanguageOne.getSelectedItem().toString();
        chooseSecondLanguage = spnSearchForLanguageTwo.getSelectedItem().toString();
        chooseThirdLanguage = spnSearchForLanguageThree.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}


