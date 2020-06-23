package guru.springframework.recipeapp.repository;

import guru.springframework.recipeapp.model.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

   //Ingredient findByRecipeIdWh(Long recipeId, Long id);
}
