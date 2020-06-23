package guru.springframework.recipeapp.controllers;

import guru.springframework.recipeapp.model.Ingredient;
import guru.springframework.recipeapp.services.IngredientService;
import guru.springframework.recipeapp.services.RecipeService;
import guru.springframework.recipeapp.services.UnitOfMeasureService;
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

    @GetMapping("/recipes/show/{id}/ingredients")
    public String showIngredients(@PathVariable("id") Long id, Model model) {
        model.addAttribute("recipe", recipeService.findById(id));
        return "recipe/ingredient/list";
    }

    @GetMapping("/recipes/show/{recipeId}/ingredient/{id}")
    public String showFormForEdit(@PathVariable ("recipeId") Long recipeId, @PathVariable ("id") Long id, Model model) {
        model.addAttribute("ingredient",ingredientService.findByRecipeIdAndIngredientId(recipeId,id));
        return "recipe/ingredient/list";
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

    @PostMapping("/recipes/ingredient/save")
    public String saveOrUpdate(@ModelAttribute("ingredient") Ingredient ingredient) {
        ingredientService.save(ingredient);
        return "redirect:/recipes";
    }
}
