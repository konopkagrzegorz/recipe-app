package guru.springframework.recipeapp.controllers;

import guru.springframework.recipeapp.services.UnitOfMeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexControlller {

    private final UnitOfMeasureService unitOfMeasureService;

    @Autowired
    public IndexControlller(UnitOfMeasureService unitOfMeasureService) {
        this.unitOfMeasureService = unitOfMeasureService;
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String getIndexPage(Model model) {
        return "index";
    }
}
