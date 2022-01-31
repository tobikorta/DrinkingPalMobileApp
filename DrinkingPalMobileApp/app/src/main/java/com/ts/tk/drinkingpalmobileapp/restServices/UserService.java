package com.ts.tk.drinkingpalmobileapp.restServices;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.ts.tk.drinkingpalmobileapp.SupportExtensions;
import com.ts.tk.drinkingpalmobileapp.dtos.UserDto;
import com.ts.tk.drinkingpalmobileapp.dtos.Value;

import org.json.JSONObject;

import lombok.AllArgsConstructor;

public class UserService {

    private final SupportExtensions activity;

    private UserService(SupportExtensions activity) {
        this.activity = activity;
    }

    public static UserService getInstance(SupportExtensions supportExtensions) {
        return new UserService(supportExtensions);
    }

    public void createUserAccount(UserDto user) {
        String url = Constants.BASE_URL + "/users";
        JSONObject jsonObject = RestUtil.convertObjectToJson(user);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, response -> {
            Value token = RestUtil.convertJsonToObject(response.toString(), Value.class);
            //TODO save token in DB
            assert token != null;
            Constants.TOKEN = token.getValue();

        }, error -> {
            System.out.println("error but request sent ");

        });
        RestUtil.sendJSONObjectRequest(jsonObjectRequest, activity);


    }

}