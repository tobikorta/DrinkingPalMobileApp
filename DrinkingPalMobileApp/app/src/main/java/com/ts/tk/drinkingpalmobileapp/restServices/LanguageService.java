package com.ts.tk.drinkingpalmobileapp.restServices;

import com.ts.tk.drinkingpalmobileapp.support.SupportExtensions;

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
