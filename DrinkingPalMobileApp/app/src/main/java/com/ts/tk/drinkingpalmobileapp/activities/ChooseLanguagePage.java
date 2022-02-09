package com.ts.tk.drinkingpalmobileapp.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.ts.tk.drinkingpalmobileapp.R;

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
        setContentView(R.layout.activity_language_page);


        Objects.requireNonNull(getSupportActionBar()).setTitle("ChooseLanguage");
        upArrow();

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String fName = bundle.getString("FNAME");
            String lName = bundle.getString("LNAME");
            String email = bundle.getString("EMAIL");
            String password = bundle.getString("PASSWORD");

            System.out.println(fName + lName + email + password);
        }



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


