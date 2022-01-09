package com.ts.tk.drinkingpalmobileapp.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Location {

    private Long id;
    private String name;
    private String address;

    @Builder
    public Location(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
