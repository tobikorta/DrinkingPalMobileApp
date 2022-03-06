package com.ts.tk.drinkingpalmobileapp.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.ts.tk.drinkingpalmobileapp.R;
import com.ts.tk.drinkingpalmobileapp.dtos.UserData;
import com.ts.tk.drinkingpalmobileapp.restServices.Constants;
import com.ts.tk.drinkingpalmobileapp.restServices.RestUtil;
import com.ts.tk.drinkingpalmobileapp.support.SupportExtensions;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ProfileDashboard extends SupportExtensions {

    private TextView textFullName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_dashboard);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Profile Dashboard");

        Button buttonContinueToEvents = findViewById(R.id.btnEvents);
        Button buttonContinueToMessages = findViewById(R.id.btnMessages);
        Button buttonContinueToFavouriteBars = findViewById(R.id.btnFavouriteBars);
        Button buttonContinueToStatsHistory = findViewById(R.id.btnStatsHistory);
        Button buttonContinueToProfileEdit = findViewById(R.id.btnProfileEdit);

        Button buttonSisconnect = findViewById(R.id.btnDisconnect);
        buttonSisconnect.setOnClickListener(v -> {
            SharedPreferences sharedPref = getSharedPreferences(
                    Constants.SHARED_PREFS_KEY, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.remove("jwt");
            editor.apply();
            openActivity(MainActivity.class);
        });
        textFullName = findViewById(R.id.txtFullName);

        buttonContinueToEvents.setOnClickListener(view -> {
            openEvents();
        });
        buttonContinueToMessages.setOnClickListener(view -> {
            openMessages();
        });
        buttonContinueToFavouriteBars.setOnClickListener(view -> {
            openFavouriteBars();
        });
        buttonContinueToStatsHistory.setOnClickListener(view -> {
            openStatsHistory();
        });
        buttonContinueToProfileEdit.setOnClickListener(view -> {
            openProfileEdit();
        });
        getCurrentUser();

    }

    private void getCurrentUser() {
        SharedPreferences sharedPref = getSharedPreferences(
                Constants.SHARED_PREFS_KEY, Context.MODE_PRIVATE);
        String token = sharedPref.getString("jwt", null);

        String url = Constants.BASE_URL + "/users/current";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, response -> {
            UserData result = RestUtil.convertJsonToObject(response.toString(), UserData.class);
            textFullName.setText(result.getFirstName() + " " + result.getLastName());
        }, error -> error.printStackTrace()) {
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> headers = new HashMap<>();
                headers.put("Authorization", "Bearer " + token);
                return headers;
            }
        };

        RestUtil.sendJSONObjectRequest(jsonObjectRequest, this);
    }


}