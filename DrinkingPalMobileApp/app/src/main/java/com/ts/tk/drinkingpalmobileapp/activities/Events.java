package com.ts.tk.drinkingpalmobileapp.activities;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.ts.tk.drinkingpalmobileapp.R;
import com.ts.tk.drinkingpalmobileapp.dtos.Bar;
import com.ts.tk.drinkingpalmobileapp.dtos.Event;
import com.ts.tk.drinkingpalmobileapp.models.RecViewEventsAdapter;
import com.ts.tk.drinkingpalmobileapp.restServices.Constants;
import com.ts.tk.drinkingpalmobileapp.restServices.RestUtil;
import com.ts.tk.drinkingpalmobileapp.support.SupportExtensions;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Events extends SupportExtensions {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Events");
        upArrow();

        recyclerView = findViewById(R.id.recViewEventScreen);
        RecViewEventsAdapter recViewEventsAdapter = new RecViewEventsAdapter(this);
        recyclerView.setAdapter(recViewEventsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getEvents(recViewEventsAdapter);
    }

    private void getEvents(RecViewEventsAdapter adapter) {
        String url = Constants.BASE_URL + "/events";
        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, url, null, response -> {
            List<Event> result = Arrays.asList(Objects.requireNonNull(RestUtil.convertJsonToObject(response.toString(), Event[].class)));
            Events.this.runOnUiThread(() -> {
                adapter.setEvents(result);
                adapter.notifyDataSetChanged();
            });
        }, error -> error.printStackTrace());
        RestUtil.sendJSONObjectRequest(jsonObjectRequest, this);
    }
}
