package guru.springframework.recipeapp.model;

import javax.persistence.*;

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
