package com.springframework.recipeapp.services;

import com.springframework.recipeapp.model.Difficulty;
import com.springframework.recipeapp.model.Recipe;
import com.springframework.recipeapp.repository.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.mock;

class RecipeServiceImplTest {

    RecipeServiceImpl recipeServiceImpl;

    @Mock
    RecipeRepository recipeRepository;

    public void setUp() {
        MockitoAnnotations.initMocks(this.recipeRepository);
        recipeServiceImpl = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeServiceImpl).build();
        //mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("index"));
    }
    @Test
    void findAll() {
        Recipe recipe = new Recipe();
        recipe.setCookTime(23);
        recipe.setPrepTime(21);
        recipe.setDifficulty(Difficulty.MODERATE);

        //when(recipeServiceImpl.findAll()).thenReturn(re)
    }

    @Test
    void findByDescription() {
    }

    @Test
    void save() {
    }

    @Test
    void deleteById() {
    }
}