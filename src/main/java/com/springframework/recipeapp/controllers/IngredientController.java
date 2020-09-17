package com.springframework.recipeapp.controllers;

import com.springframework.recipeapp.model.Ingredient;
import com.springframework.recipeapp.model.Recipe;
import com.springframework.recipeapp.model.UnitOfMeasure;
import com.springframework.recipeapp.services.IngredientService;
import com.springframework.recipeapp.services.RecipeService;
import com.springframework.recipeapp.services.UnitOfMeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class IngredientController {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final UnitOfMeasureService unitOfMeasureService;

    @Autowired
    public IngredientController(RecipeService recipeService, IngredientService ingredientService,
                                UnitOfMeasureService unitOfMeasureService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.unitOfMeasureService = unitOfMeasureService;
    }

    @GetMapping("/recipes/show/{recipeId}/ingredients")
    public String showIngredients(@PathVariable("recipeId") Long recipeId, Model model) {
        model.addAttribute("recipe", recipeService.findById(recipeId));
        return "recipe/ingredient/ingredient-list";
    }

    @GetMapping("/recipes/show/{recipeId}/delete/{id}")
    public String deleteIngredient(@PathVariable ("recipeId") Long recipeId, @PathVariable ("id") Long id) {
        ingredientService.deleteById(id);
        return  "redirect:/recipes/show/{recipeId}/ingredients";
    }

    @GetMapping("/recipes/show/{recipeId}/ingredient/{id}/update")
    public String updateIngredient(@PathVariable ("recipeId") Long recipeId, @PathVariable ("id") Long id, Model model) {
        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredientId(recipeId,id));
        model.addAttribute("uomList", unitOfMeasureService.findAll());
        return "recipe/ingredient/ingredient-form";
    }

    @GetMapping("/recipes/{recipeId}/ingredient/add-new")
    public String addIngredient(@PathVariable ("recipeId") Long recipeId, Model model) {
        Ingredient ingredient = new Ingredient();
        Recipe recipe = recipeService.findById(recipeId);
        ingredient.setRecipe(recipe);
        ingredient.setUom(new UnitOfMeasure());
        model.addAttribute("ingredient", ingredient);
        model.addAttribute("uomList", unitOfMeasureService.findAll());
        return "recipe/ingredient/ingredient-form";
    }

    @PostMapping("/recipes/show/{recipeId}/ingredient")
    public String saveOrUpdate(@PathVariable ("recipeId") Long id, @ModelAttribute ("ingredient") Ingredient ingredient) {
        ingredientService.save(ingredient);
        return "redirect:/recipes/show/" + ingredient.getRecipeId();
    }
}
