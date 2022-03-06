package com.ts.tk.drinkingpalmobileapp.restServices;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.ts.tk.drinkingpalmobileapp.support.SupportExtensions;
import com.ts.tk.drinkingpalmobileapp.dtos.UserDto;
import com.ts.tk.drinkingpalmobileapp.dtos.Value;

import org.json.JSONObject;

public class UserService {

    private final SupportExtensions activity;

    public UserService(SupportExtensions activity) {
        this.activity = activity;
    }

    public void createUserAccount(UserDto user) {
        String url = Constants.BASE_URL + "/users";
        JSONObject jsonObject = RestUtil.convertObjectToJson(user);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, response -> {
            Value token = RestUtil.convertJsonToObject(response.toString(), Value.class);
            assert token != null;
            SharedPreferences sharedPref = activity.getSharedPreferences(
                    Constants.SHARED_PREFS_KEY, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("jwt", token.getValue());
            editor.apply();
            Constants.TOKEN = token.getValue();

        }, error -> {
            System.out.println("error but request sent ");

        });
        RestUtil.sendJSONObjectRequest(jsonObjectRequest, activity);
    }

}
