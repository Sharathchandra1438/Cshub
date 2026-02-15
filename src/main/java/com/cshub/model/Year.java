package com.cshub.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Year {

    FIRST_YEAR,
    SECOND_YEAR,
    THIRD_YEAR,
    FOURTH_YEAR;

    @JsonCreator
    public static Year fromValue(String value) {

        value = value.trim().toLowerCase();

        return switch (value) {
            case "1st year", "first", "first year", "1", "first_year" -> FIRST_YEAR;
            case "2nd year", "second", "second year", "2", "second_year" -> SECOND_YEAR;
            case "3rd year", "third", "third year", "3", "third_year" -> THIRD_YEAR;
            case "4th year", "fourth", "fourth year", "4", "fourth_year" -> FOURTH_YEAR;
            default -> throw new IllegalArgumentException("Invalid year value");
        };
    }

    @JsonValue
    public String toJson() {
        return this.name().replace("_", " ");
    }
}
