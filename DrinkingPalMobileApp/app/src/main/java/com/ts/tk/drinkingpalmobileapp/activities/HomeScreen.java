package com.ts.tk.drinkingpalmobileapp.activities;

import android.os.Bundle;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.ts.tk.drinkingpalmobileapp.R;
import com.ts.tk.drinkingpalmobileapp.dtos.Bar;
import com.ts.tk.drinkingpalmobileapp.models.AppRoomDatabase;
import com.ts.tk.drinkingpalmobileapp.models.RecViewBarsAdapter;
import com.ts.tk.drinkingpalmobileapp.restServices.Constants;
import com.ts.tk.drinkingpalmobileapp.restServices.RestUtil;
import com.ts.tk.drinkingpalmobileapp.support.SupportExtensions;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class HomeScreen extends SupportExtensions {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        Objects.requireNonNull(getSupportActionBar()).setTitle("HomeScreen");

        Button buttonContinueToDashboard = findViewById(R.id.btnProfileDashboard);
        buttonContinueToDashboard.setOnClickListener(view -> {
            openProfileDashboard();
        });

        recyclerView = findViewById(R.id.recViewHomeScreen);

        RecViewBarsAdapter recViewBarsAdapter = new RecViewBarsAdapter(this);
        recyclerView.setAdapter(recViewBarsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getBars(recViewBarsAdapter);
    }

    private void getBars(RecViewBarsAdapter recViewBarsAdapter) {
        String url = Constants.BASE_URL + "/bars";
        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, url, null, response -> {
            List<Bar> result = Arrays.asList(Objects.requireNonNull(RestUtil.convertJsonToObject(response.toString(), Bar[].class)));
            HomeScreen.this.runOnUiThread(() -> {
                recViewBarsAdapter.setBars(result);
                recViewBarsAdapter.notifyDataSetChanged();
            });
        }, error -> error.printStackTrace());
        RestUtil.sendJSONObjectRequest(jsonObjectRequest, this);
    }
}