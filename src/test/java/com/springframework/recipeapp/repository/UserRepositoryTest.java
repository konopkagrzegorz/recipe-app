package com.springframework.recipeapp.repository;

import com.springframework.recipeapp.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    //need to fix
    @Test
    public void findUserByUsername() {
        User user = userRepository.findUserByUsername("olo");
        assertEquals("olo", user.getUsername());
    }

    @Test(expected = NullPointerException.class)
    public void findUserByUsername_shouldReturnNoSuchElementException() {
        User user = userRepository.findUserByUsername("admin");
        assertEquals("admin", user.getUsername());
    }
}