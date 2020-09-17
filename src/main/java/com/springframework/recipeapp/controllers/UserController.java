package com.springframework.recipeapp.controllers;

import com.springframework.recipeapp.model.User;
import com.springframework.recipeapp.model.UserRegistrationDTO;
import com.springframework.recipeapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    private UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDTO userRegistrationDTO(){
        return new UserRegistrationDTO();
    }

    @GetMapping("/login")
    public String login() {
        return "recipe/login";
    }

    @GetMapping("/registration")
    public String showRegistrationForm() {
        return "recipe/register";
    }

    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDTO userDto,
                                      BindingResult result){

        User existing = userService.findByUsername(userDto.getUsername());
        if (existing != null){
            result.rejectValue("username", null, "There is already an account registered with that username");
        }

        if (result.hasErrors()){
            return "/recipe/register";
        }
        userService.save(userDto);
        return "redirect:/registration?success";
    }
}
