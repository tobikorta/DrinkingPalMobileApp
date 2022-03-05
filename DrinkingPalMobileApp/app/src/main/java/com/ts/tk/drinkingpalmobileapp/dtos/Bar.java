package com.ts.tk.drinkingpalmobileapp.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Bar {
    private Long id;
    private String name;
    private double longitude;
    private double latitude;
    private String description;


}
