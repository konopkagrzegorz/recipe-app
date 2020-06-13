package guru.springframework.recipeapp.services;

import guru.springframework.recipeapp.model.Recipe;
import guru.springframework.recipeapp.model.UnitOfMeasure;
import guru.springframework.recipeapp.repository.RecipeRepository;
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
    public void save(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    @Override
    public void deleteById(Long id) {
        recipeRepository.deleteById(id);
    }
}

