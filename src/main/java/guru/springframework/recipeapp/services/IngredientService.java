package guru.springframework.recipeapp.services;

import guru.springframework.recipeapp.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IngredientService {

    Ingredient findByRecipeIdAndIngredientId(Long recipeId, Long id);
    void deleteById(Long id);
    Ingredient save(Ingredient ingredient);
}
