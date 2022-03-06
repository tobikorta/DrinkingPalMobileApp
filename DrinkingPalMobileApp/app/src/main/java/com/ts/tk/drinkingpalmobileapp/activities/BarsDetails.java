package com.ts.tk.drinkingpalmobileapp.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.ts.tk.drinkingpalmobileapp.R;
import com.ts.tk.drinkingpalmobileapp.dtos.Bar;
import com.ts.tk.drinkingpalmobileapp.restServices.Constants;
import com.ts.tk.drinkingpalmobileapp.support.SupportExtensions;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BarsDetails extends SupportExtensions {

    private TextView barNameTextView;
    private TextView barDescriptionTextView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bars_details);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Details");
        upArrow();

        this.barNameTextView = findViewById(R.id.lblTitleBar);
        this.barDescriptionTextView = findViewById(R.id.lblDescription);
        this.imageView =findViewById(R.id.imageView3);


        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            return;
        }
        Bar bar = (Bar) bundle.get("bar");
        barNameTextView.setText(bar.getName());
        barDescriptionTextView.setText(bar.getDescription());
        Picasso.get().load(Constants.BASE_URL + "/bars/image/" + bar.getId()).into(this.imageView);

        Button createEventButton = findViewById(R.id.btnCreateEvent);
        createEventButton.setOnClickListener(v -> {
            Map<String, Bar> extras = new HashMap<>();
            extras.put("bar", bar);
            openActivity(NewEvent.class, extras);
        });



    }

}
