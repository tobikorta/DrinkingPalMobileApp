package com.ts.tk.drinkingpalmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class ChooseLanguagePage extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener {

    private Spinner spnSearchForLanguage;
    private Button btnChooseLanguageEnglish;
    private Button btnChooseLanguageGerman;
    private Button btnChooseLanguageSpanish;
    private Button btnChooseLanguageFrench;
    private Button btnChooseLanguageMandarin;
    private Button btnChooseLanguagePortuguese;
    private Button btnContinueToFinishSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_language_page);

        Spinner spinner = (Spinner) findViewById(R.id.spnSearchForLanguage);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.chooseLanguageSpinner, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}