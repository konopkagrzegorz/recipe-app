package com.springframework.recipeapp.services;

import com.springframework.recipeapp.exceptions.NotFoundException;
import com.springframework.recipeapp.model.Category;
import com.springframework.recipeapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void delete(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    @Override
    public Category findById(Long categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);

        if (!category.isPresent()) {
            throw new NotFoundException("Category with " + category + " not found!");
        }
        return category.get();
    }
}
