package com.ts.tk.drinkingpalmobileapp.activities;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TimePicker;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.squareup.picasso.Picasso;
import com.ts.tk.drinkingpalmobileapp.R;
import com.ts.tk.drinkingpalmobileapp.dtos.Bar;
import com.ts.tk.drinkingpalmobileapp.dtos.Event;
import com.ts.tk.drinkingpalmobileapp.restServices.Constants;
import com.ts.tk.drinkingpalmobileapp.restServices.RestUtil;
import com.ts.tk.drinkingpalmobileapp.support.SupportExtensions;

import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class NewEvent extends SupportExtensions {

    private Button eventDateButton;
    private Button eventTimeButton;

    private Bar selectedBar;

    private DateTimeContainer dateTimeContainer = new DateTimeContainer();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Create new Event");
        upArrow();

        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            return;
        }
        Bar bar = (Bar) bundle.get("bar");
        this.selectedBar = bar;
        ImageView barImage = findViewById(R.id.imageView);
        Picasso.get().load(Constants.BASE_URL + "/bars/image/" + bar.getId()).into(barImage);

        eventDateButton = findViewById(R.id.eventDateInput);
        eventTimeButton = findViewById(R.id.eventTimeInput);

        eventDateButton.setOnClickListener(v -> {
            DatePickerFragment newFragment = new DatePickerFragment();
            newFragment.dateButton = eventDateButton;
            newFragment.dateTimeContainer = dateTimeContainer;
            newFragment.show(getSupportFragmentManager(), "datePicker");
        });
        eventTimeButton.setOnClickListener(v -> {
            TimePickerFragment newFragment = new TimePickerFragment();
            newFragment.timeButton = eventTimeButton;
            newFragment.dateTimeContainer = dateTimeContainer;
            newFragment.show(getSupportFragmentManager(), "timePicker");
        });

        Button saveButton = findViewById(R.id.saveEvent);
        saveButton.setOnClickListener(v -> {
            Event event = new Event();
            event.setBar(bar);
            event.setDate(dateTimeContainer.getDate());
            saveEvent(event);
        });

    }

    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

        private Button timeButton;
        private DateTimeContainer dateTimeContainer;

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            timeButton.setText(hourOfDay + ":" + minute);
            dateTimeContainer.hour = hourOfDay;
            dateTimeContainer.minute = minute;

        }
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        private Button dateButton;
        private DateTimeContainer dateTimeContainer;

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            dateButton.setText(day + "." + month + "." + year);
            dateTimeContainer.year = year;
            dateTimeContainer.month = month;
            dateTimeContainer.day = day;
        }
    }

    private static class DateTimeContainer {
        private int year;
        private int month;
        private int day;

        private int hour;
        private int minute;

        @RequiresApi(api = Build.VERSION_CODES.O)
        public Date getDate() {
            LocalDateTime localDateTime = LocalDateTime.of(year, month, day, hour, minute);
            return java.util.Date
                    .from(localDateTime.atZone(ZoneId.systemDefault())
                            .toInstant());
        }
    }

    private void saveEvent(Event event) {
        SharedPreferences sharedPref = getSharedPreferences(
                Constants.SHARED_PREFS_KEY, Context.MODE_PRIVATE);
        String token = sharedPref.getString("jwt", null);
        String url = Constants.BASE_URL + "/events";
        final JSONObject jsonObject = RestUtil.convertObjectToJson(event);
        System.out.println(jsonObject.toString());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, response -> {
            this.openActivity(HomeScreen.class);
        }, Throwable::printStackTrace) {
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
