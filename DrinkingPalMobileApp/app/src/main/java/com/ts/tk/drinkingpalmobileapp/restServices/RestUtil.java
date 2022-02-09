package com.ts.tk.drinkingpalmobileapp.restServices;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ts.tk.drinkingpalmobileapp.activities.SupportExtensions;

import org.json.JSONObject;

import java.io.IOException;

public class RestUtil {

    public static JSONObject convertObjectToJson(Object object) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return new JSONObject(objectMapper.writeValueAsString(object));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T convertJsonToObject(String json, Class<T> clazz) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void sendJSONObjectRequest(JsonObjectRequest objectRequest, SupportExtensions activity) {
        RequestQueue queue = Volley.newRequestQueue(activity);
        queue.start();
        queue.add(objectRequest);
    }

    public static void sendJSONObjectRequest(JsonArrayRequest objectRequest, SupportExtensions activity) {
        RequestQueue queue = Volley.newRequestQueue(activity);
        queue.start();
        queue.add(objectRequest);
    }
}
