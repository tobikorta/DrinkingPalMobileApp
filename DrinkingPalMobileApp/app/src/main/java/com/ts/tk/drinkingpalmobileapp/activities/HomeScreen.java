package com.ts.tk.drinkingpalmobileapp.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.ts.tk.drinkingpalmobileapp.R;
import com.ts.tk.drinkingpalmobileapp.models.AppRoomDatabase;
import com.ts.tk.drinkingpalmobileapp.models.RecViewBarsAdapter;

import java.util.Objects;

public class HomeScreen extends SupportExtensions {

    private Button buttonSearch;
    RecyclerView recyclerView;

    String s1[], s2[];
    int images[] = {R.drawable.bild_mvv_paris};

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

        RecViewBarsAdapter recViewBarsAdapter = new RecViewBarsAdapter(this, s1, s2, images);
        recyclerView.setAdapter(recViewBarsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        AppRoomDatabase db = Room.databaseBuilder(getApplicationContext(), AppRoomDatabase.class, "Database 1").build();
    }


}