package com.ts.tk.drinkingpalmobileapp.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.ts.tk.drinkingpalmobileapp.R;
import com.ts.tk.drinkingpalmobileapp.dtos.Language;
import com.ts.tk.drinkingpalmobileapp.dtos.UserDto;
import com.ts.tk.drinkingpalmobileapp.restServices.Constants;
import com.ts.tk.drinkingpalmobileapp.restServices.RestUtil;
import com.ts.tk.drinkingpalmobileapp.restServices.UserService;
import com.ts.tk.drinkingpalmobileapp.support.SupportExtensions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class ChooseLanguagePage extends SupportExtensions implements AdapterView.OnItemSelectedListener {



    private final UserService userService;

    private List<Language> languages = new ArrayList<>();
    private Object chooseFirstLanguage;
    private  Spinner spinnerOne;

    public ChooseLanguagePage() {
        userService = new UserService(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_page);


        Objects.requireNonNull(getSupportActionBar()).setTitle("ChooseLanguage");
        upArrow();

        spinnerOne = findViewById(R.id.spnSearchForLanguageOne);

        List<String> languageNames = new ArrayList<>();

        @SuppressLint("ResourceType") ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, languageNames);

        getLanguages(adapter, languageNames);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerOne.setAdapter(adapter);

        Button buttonContinueToHomeScreen = findViewById(R.id.btnContinueToHomeScreen);
        buttonContinueToHomeScreen.setOnClickListener(view -> {


            Bundle bundle = getIntent().getExtras();
            if (bundle != null) {
                spinnerOne.setOnItemSelectedListener(this);
                String languageName = spinnerOne.getSelectedItem().toString();

                String firstName = bundle.getString("FNAME");
                String lastName = bundle.getString("LNAME");
                String email = bundle.getString("EMAIL");
                String password = bundle.getString("PASSWORD");
                Language language = this.languages.stream().filter(l -> l.getName().equals(languageName)).findFirst().orElse(null);
                System.out.println(language);

                UserDto user = UserDto.builder().firstName(firstName)
                        .lastName(lastName)
                        .email(email)
                        .password(password)
                        .spokenLanguages(new HashSet<>(Collections.singletonList(language)))
                        .build();

                userService.createUserAccount(user);

                openHomeScreen(email, password);
                autoKeyboardRemover();
            }

        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapter, View view, int position, long id) {
        chooseFirstLanguage = adapter.getItemAtPosition(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void getLanguages(ArrayAdapter<String> adapter, List<String> languageNamesList) {
        String url = Constants.BASE_URL + "/languages";
        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, url, null, response -> {
            List<Language> result = Arrays.asList(RestUtil.convertJsonToObject(response.toString(), Language[].class));

            ChooseLanguagePage.this.runOnUiThread(() -> {
                result.stream().map(Language::getName).forEach(languageNamesList::add);
                adapter.notifyDataSetChanged();
            });

            this.languages = result;
        }, error -> error.printStackTrace());
        RestUtil.sendJSONObjectRequest(jsonObjectRequest, this);
    }

}


