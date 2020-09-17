package com.springframework.recipeapp.services;

import com.springframework.recipeapp.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();
    Category findById(Long categoryId);
    void save(Category category);
    void delete (Long categoryId);
}
