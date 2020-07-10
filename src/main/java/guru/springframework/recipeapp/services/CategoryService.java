package guru.springframework.recipeapp.services;

import guru.springframework.recipeapp.model.Category;
import guru.springframework.recipeapp.model.Recipe;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();
    Category findById(Long categoryId);
    void save(Category category);
    void delete (Long categoryId);
}
