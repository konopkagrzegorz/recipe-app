package com.springframework.recipeapp.services;

import com.springframework.recipeapp.model.RecipeUserDetails;
import com.springframework.recipeapp.model.User;
import com.springframework.recipeapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//public class RecipeUserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username)
//            throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//
//        if (user == null) {
//            throw new UsernameNotFoundException("Could not find user");
//        }
//        return new RecipeUserDetails(user);
//    }
//}
