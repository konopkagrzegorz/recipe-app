package com.springframework.recipeapp.model;

import com.springframework.recipeapp.validation.FieldMatch;
import com.springframework.recipeapp.validation.FieldMatchValidator;

import javax.validation.constraints.*;

@FieldMatch.List({@FieldMatch(
                 firstValue= "password",
                secondValue = "confirmPassword"
        )})

public class UserRegistrationDTO {

    @NotBlank(message = "This field cannot be empty")
    @Size(min = 3, max = 15, message = "Username must be between {min} and {max}")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "You can use only letters or numbers")
    private String username;

    @NotBlank(message = "This field cannot be empty")
    @Size(min = 3, max = 15, message = "Username must be between {min} and {max}")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "You can use only letters or numbers")
    private String password;

    @NotBlank(message = "This field cannot be empty")
    @Size(min = 3, max = 15, message = "Username must be between {min} and {max}")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "You can use only letters or numbers")
    private String confirmPassword;

    @AssertTrue
    private Boolean terms;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Boolean getTerms() {
        return terms;
    }

    public void setTerms(Boolean terms) {
        this.terms = terms;
    }
}