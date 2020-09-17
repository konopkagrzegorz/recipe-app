package com.springframework.recipeapp.services;

import com.springframework.recipeapp.exceptions.NotFoundException;
import com.springframework.recipeapp.model.Recipe;
import com.springframework.recipeapp.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> findAll() {
        return (List<Recipe>) recipeRepository.findAll();
    }

    @Override
    public Optional<Recipe> findByDescription(String description) {
        return recipeRepository.findByDescription(description);
    }

    @Override
    public Recipe findById(Long id) {

        Optional<Recipe> result = recipeRepository.findById(id);
        if (!result.isPresent()) {
            throw new NotFoundException("Recipe with id " + id + " not found!");
        }
        return result.get();
    }

    @Override
    public void save(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    @Override
    public void deleteById(Long id) {
        recipeRepository.deleteById(id);
    }
}