package com.ts.tk.drinkingpalmobileapp.activities;

import android.content.Context;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
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

    private Button buttonSearch;
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

        RecViewBarsAdapter recViewBarsAdapter = new RecViewBarsAdapter(this, new String[0], new String[0], new Long[0]);
        recyclerView.setAdapter(recViewBarsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
//                System.out.println("#######################################");
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

        getBars(recViewBarsAdapter);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        AppRoomDatabase db = Room.databaseBuilder(getApplicationContext(), AppRoomDatabase.class, "Database 1").build();
    }

    private void getBars(RecViewBarsAdapter recViewBarsAdapter) {
        String url = Constants.BASE_URL + "/bars";
        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, url, null, response -> {
            List<Bar> result = Arrays.asList(RestUtil.convertJsonToObject(response.toString(), Bar[].class));
            HomeScreen.this.runOnUiThread(() -> {
                String[] barNames = result.stream().map(Bar::getName).toArray(String[]::new);
                String[] descriptions = result.stream().map(Bar::getDescription).toArray(String[]::new);
                Long[] ids = result.stream().map(Bar::getId).toArray(Long[]::new);
                recViewBarsAdapter.setBarNames(barNames);
                recViewBarsAdapter.setBarDescriptions(descriptions);
                recViewBarsAdapter.setBarIds(ids);
                recViewBarsAdapter.notifyDataSetChanged();
            });
        }, error -> error.printStackTrace());
        RestUtil.sendJSONObjectRequest(jsonObjectRequest, this);
    }
}