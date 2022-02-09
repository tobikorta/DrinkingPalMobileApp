package com.ts.tk.drinkingpalmobileapp.restServices;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.ts.tk.drinkingpalmobileapp.activities.SupportExtensions;
import com.ts.tk.drinkingpalmobileapp.dtos.Language;

import java.util.Arrays;
import java.util.List;

public class LanguageService {

    private final SupportExtensions activity;

    private LanguageService(SupportExtensions activity) {
        this.activity = activity;
    }

    public static LanguageService getInstance(SupportExtensions supportExtensions) {
        return new LanguageService(supportExtensions);
    }

    public void getAllLanguages() {
        String url = Constants.BASE_URL + "/languages";
        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, url, null, response -> {
            List<Language> result = Arrays.asList(RestUtil.convertJsonToObject(response.toString(), Language[].class));

        }, error -> {
            System.out.println("error but request sent ");

        });
        RestUtil.sendJSONObjectRequest(jsonObjectRequest, activity);


    }
}
