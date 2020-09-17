package com.springframework.recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {


    @RequestMapping({"/",""})
    public String showIndex() {
        return "index";
    }

    @RequestMapping("/access-denied")
    public String handleForbiddenException() {
        return "recipe/403error";
    }
}
