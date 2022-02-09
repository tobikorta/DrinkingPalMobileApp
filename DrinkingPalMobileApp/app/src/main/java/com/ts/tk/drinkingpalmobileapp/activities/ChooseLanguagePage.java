package com.ts.tk.drinkingpalmobileapp.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.ts.tk.drinkingpalmobileapp.R;
import com.ts.tk.drinkingpalmobileapp.dtos.UserDto;
import com.ts.tk.drinkingpalmobileapp.restServices.UserService;

import java.util.Objects;

public class ChooseLanguagePage extends SupportExtensions implements AdapterView.OnItemSelectedListener{

    private Spinner spnSearchForLanguage;

    private Object chooseFirstLanguage;
    private Object userInfo;

    private UserService userService;

    public ChooseLanguagePage() {
        userService = new UserService(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_page);


        Objects.requireNonNull(getSupportActionBar()).setTitle("ChooseLanguage");
        upArrow();

        Spinner spinnerOne = findViewById(R.id.spnSearchForLanguageOne);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.chooseLanguageSpinner, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerOne.setAdapter(adapter);

        Button buttonContinueToHomeScreen = findViewById(R.id.btnContinueToHomeScreen);
        buttonContinueToHomeScreen.setOnClickListener(view -> {

            Bundle bundle = getIntent().getExtras();
            if(bundle != null){
                String firstName = bundle.getString("FNAME");
                String lastName = bundle.getString("LNAME");
                String email = bundle.getString("EMAIL");
                String password = bundle.getString("PASSWORD");

                spinnerOne.setOnItemSelectedListener(this);
                String language = spinnerOne.getSelectedItem().toString();

                UserDto user = UserDto.builder().firstName(firstName)
                        .lastName(lastName)
                        .email(email)
                        .password(password)
                        .build();

                userService.createUserAccount(user);

                userInfo = firstName + lastName + email + password + language;
                //System.out.println(userInfo);

            }

            openHomeScreen();
            autoKeyboardRemover();

        });

    }

        @Override
        public void onItemSelected(AdapterView<?> adapter, View view, int position, long id) {

            chooseFirstLanguage = adapter.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

    }

}


