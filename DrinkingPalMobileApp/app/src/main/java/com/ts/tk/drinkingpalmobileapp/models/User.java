package com.ts.tk.drinkingpalmobileapp.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {

    private Long id;
    private String name;

    @Builder
    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
