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



    }
}
