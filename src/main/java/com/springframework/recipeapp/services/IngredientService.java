package com.springframework.recipeapp.services;

import com.springframework.recipeapp.model.Ingredient;

public interface IngredientService {

    Ingredient findByRecipeIdAndIngredientId(Long recipeId, Long id);
    void deleteById(Long id);
    void save(Ingredient ingredient);
}
