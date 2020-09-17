package com.springframework.recipeapp.controllers;

import com.springframework.recipeapp.model.Category;
import com.springframework.recipeapp.model.Recipe;
import com.springframework.recipeapp.services.CategoryService;
import com.springframework.recipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final RecipeService recipeService;
    private final CategoryService categoryService;

    public CategoryController(RecipeService recipeService, CategoryService categoryService) {
        this.recipeService = recipeService;
        this.categoryService = categoryService;
    }

    @GetMapping({"/",""})
    public String getCategories(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "recipe/category/categories-list";
    }

    @GetMapping("/add-new")
    public String addNewCategory(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "recipe/category/category-form";
    }

    @PostMapping("/save")
    public String saveOrUpdate(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "recipe/category/category-form";
        }
        categoryService.save(category);
        return "redirect:/categories/";
    }

    @GetMapping("/delete/{categoryId}")
    public String deleteCategory(@PathVariable("categoryId") Long categoryId) {
        Category category = categoryService.findById(categoryId);
        List<Recipe> recipeList = recipeService.findAll();
        for (Recipe recipe : recipeList) {
            if (recipe.getCategories().contains(category)) {
                recipe.getCategories().remove(category);
                recipeService.save(recipe);
            }
        }
        categoryService.delete(categoryId);
        return "redirect:/categories";
    }
}
