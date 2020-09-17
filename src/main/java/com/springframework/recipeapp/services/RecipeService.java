package com.springframework.recipeapp.services;

import com.springframework.recipeapp.model.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeService {

    List<Recipe> findAll();

    Recipe findById(Long id);

    Optional<Recipe> findByDescription(String description);

    void save(Recipe recipe);

    void deleteById(Long id);
}
