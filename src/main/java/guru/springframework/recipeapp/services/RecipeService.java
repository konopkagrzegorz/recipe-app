package guru.springframework.recipeapp.services;

import guru.springframework.recipeapp.model.Recipe;
import guru.springframework.recipeapp.model.UnitOfMeasure;

import java.util.List;
import java.util.Optional;

public interface RecipeService {

    List<Recipe> findAll();

    Recipe findById(Long id);

    Optional<Recipe> findByDescription(String description);

    void save(Recipe recipe);

    void deleteById(Long id);
}
