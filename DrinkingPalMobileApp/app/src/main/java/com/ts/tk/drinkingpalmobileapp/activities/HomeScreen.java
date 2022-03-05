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

    private Button buttonSearch;
    RecyclerView recyclerView;

    String s1[], s2[];
    int images[] = {R.drawable.bild_mvv_paris, R.drawable.bild_mvv_paris};

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

        s1 = getResources().getStringArray(R.array.title_bar);
        s2 = getResources().getStringArray(R.array.description);

        RecViewBarsAdapter recViewBarsAdapter = new RecViewBarsAdapter(this, new String[0], new String[0], new Long[0]);
        recyclerView.setAdapter(recViewBarsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

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