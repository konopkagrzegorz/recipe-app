package com.springframework.recipeapp.services;

import com.springframework.recipeapp.model.User;
import com.springframework.recipeapp.model.UserRegistrationDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUsername(String username);
    User save(UserRegistrationDTO user);



}
