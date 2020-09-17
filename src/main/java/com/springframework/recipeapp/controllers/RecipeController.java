package com.springframework.recipeapp.controllers;

import com.springframework.recipeapp.model.Recipe;
import com.springframework.recipeapp.services.CategoryService;
import com.springframework.recipeapp.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService recipeService;
    private final CategoryService categoryService;

    @Autowired
    public RecipeController(RecipeService recipeService, CategoryService categoryService) {
        this.recipeService = recipeService;
        this.categoryService = categoryService;
    }

    @GetMapping({"/",""})
    public String getRecipes(Model model) {
        model.addAttribute("recipes",recipeService.findAll());
        return "recipe/recipes-list";
    }

    @GetMapping("/show/{id}")
    public String showRecipeDetails(@PathVariable("id") Long id, Model model) {

        Recipe recipe = recipeService.findById(id);
        model.addAttribute("recipe", recipe);
        return "recipe/show";
    }

    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable ("id") Long id, Model model) {
        model.addAttribute("recipe", recipeService.findById(id));
        model.addAttribute("categories", categoryService.findAll());
        return "recipe/form";
    }

    @GetMapping("/add-new")
    public String addNewRecipe(Model model) {
        Recipe recipe = new Recipe();
        model.addAttribute("recipe", recipe);
        model.addAttribute("categories", categoryService.findAll());
        return "recipe/form";
    }

    @PostMapping("/save")
    public String saveOrUpdate(@Valid @ModelAttribute ("recipe") Recipe recipe, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories",categoryService.findAll());
            return "recipe/form";
        }
        recipeService.save(recipe);
        return "redirect:/recipes/show/" + recipe.getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteRecipe(@PathVariable ("id") Long id) {
        recipeService.deleteById(id);
        return "redirect:/recipes";
    }
}