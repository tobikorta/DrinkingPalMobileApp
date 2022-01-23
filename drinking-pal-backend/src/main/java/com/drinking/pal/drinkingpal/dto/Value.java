package com.drinking.pal.drinkingpal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Value<T> {
    private T value;
}
