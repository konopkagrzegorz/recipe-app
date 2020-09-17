package com.springframework.recipeapp.controllers;

import com.springframework.recipeapp.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundException(Exception exception, Model model) {
        model.addAttribute("exception", exception);
        return "recipe/404error";
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ModelAndView handleNumberFormatException(Exception exception) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("recipe/400error");
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }
}