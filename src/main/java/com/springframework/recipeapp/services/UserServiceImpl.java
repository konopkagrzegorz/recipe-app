package com.springframework.recipeapp.services;

import com.springframework.recipeapp.model.Role;
import com.springframework.recipeapp.model.User;
import com.springframework.recipeapp.model.UserRegistrationDTO;
import com.springframework.recipeapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public User save(UserRegistrationDTO user) {
        User temp = new User();

        temp.setUsername(user.getUsername());
        temp.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        temp.setRoles(Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(temp);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User temp = findByUsername(username);

        if (temp == null) {
            throw new UsernameNotFoundException("Invalid username and/or password");
        }
        return new org.springframework.security.core.userdetails.User(temp.getUsername(),
                temp.getPassword(),
                mapRolesToAuthorities(temp.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole()))
                .collect(Collectors.toList());
    }
}