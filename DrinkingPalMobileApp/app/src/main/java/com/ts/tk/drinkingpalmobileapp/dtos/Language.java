package com.ts.tk.drinkingpalmobileapp.dtos;

import java.util.Objects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Language {

    private Long id;
    private String name;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Language language = (Language) o;
        return Objects.equals(getName(), language.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
