package com.springframework.recipeapp.repository;

import com.springframework.recipeapp.model.Recipe;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RecipeRepositoryTest {


    @Autowired
    RecipeRepository recipeRepository;

    @Test
    public void findByDescription() {
        Optional<Recipe> recipe = recipeRepository.findByDescription("Perfect Guacamole");
        assertEquals("Perfect Guacamole", recipe.get().getDescription());
    }

    @Test(expected = NoSuchElementException.class)
    public void findByDescription_shouldThrowNotFoundException() {
        Optional<Recipe> recipe = recipeRepository.findByDescription("Should throw an exception");
        assertEquals("Perfect Guacamole", recipe.get().getDescription());
    }
}