package guru.springframework.recipeapp.services;

import guru.springframework.recipeapp.exceptions.NotFoundException;
import guru.springframework.recipeapp.model.Ingredient;
import guru.springframework.recipeapp.model.Recipe;
import guru.springframework.recipeapp.model.UnitOfMeasure;
import guru.springframework.recipeapp.repository.IngredientRepository;
import guru.springframework.recipeapp.repository.RecipeRepository;
import guru.springframework.recipeapp.repository.UnitOfMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.ingredientRepository = ingredientRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public Ingredient findByRecipeIdAndIngredientId(Long recipeId, Long id) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if (!recipeOptional.isPresent()) {
            throw new NotFoundException("Recipe with id " + recipeId + " not found!");
        }
            Recipe recipe = recipeOptional.get();
            Optional<Ingredient> ingredientOptional = recipe.getIngredients().stream()
                    .filter(ingredient -> ingredient.getId().equals(id)).findFirst();
            if (!ingredientOptional.isPresent()) {
                throw new NotFoundException("Ingredient with id " + id + " not found!");
            }
        return ingredientOptional.get();
    }

    @Override
    public void deleteById(Long id) {
        ingredientRepository.deleteById(id);
    }

    @Override
    public void save(Ingredient ingredient) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(ingredient.getRecipeId());
        if (!recipeOptional.isPresent()) {
            throw new RuntimeException("Recipe doesn't exist");
        } else {
            Recipe recipe = recipeOptional.get();
            Optional<Ingredient> ingredientOptional = recipe.getIngredients().stream()
                    .filter(ingredient1 -> ingredient1.getId().equals(ingredient.getId())).findFirst();
            if (ingredientOptional.isPresent()) {
                ingredient.setRecipe(recipe);
            } else {
                recipe.addIngredient(ingredient);
            }
            ingredientRepository.save(ingredient);
        }
    }
}
