package com.springframework.recipeapp.model;

public enum Difficulty {

    EASY("Easy"),
    MODERATE("Moderate"),
    HARD("Hard");

    private final String displayValue;

    Difficulty(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
