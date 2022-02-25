package com.ts.tk.drinkingpalmobileapp.dtos;

import lombok.Builder;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class LanguageDto {

    private String language;

    @Builder
    public LanguageDto(String language){
        this.language = language;
    }

    public String getLanguage(){return language;}

    public void setLanguage(String language){this.language = language;}
}
