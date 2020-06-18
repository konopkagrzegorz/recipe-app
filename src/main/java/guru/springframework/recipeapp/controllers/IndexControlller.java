package guru.springframework.recipeapp.controllers;

import guru.springframework.recipeapp.services.RecipeService;
import guru.springframework.recipeapp.services.UnitOfMeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexControlller {

    private final RecipeService recipeService;

    @Autowired
    public IndexControlller(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String getIndexPage(Model model) {
        model.addAttribute("recipes",recipeService.findAll());
        return "index";
    }
}
