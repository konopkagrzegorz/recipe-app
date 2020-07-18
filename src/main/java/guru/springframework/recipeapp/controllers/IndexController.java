package guru.springframework.recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {


    @RequestMapping({"/",""})
    public String showIndex() {
        return "index";
    }

    @RequestMapping({"/login","/login.hml"})
    public String login() {
        return "recipe/login";
    }

    @RequestMapping("/access-denied")
    public String handleForbiddenException() {
        return "recipe/403error";
    }
}
