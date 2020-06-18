package guru.springframework.recipeapp.controllers;

import guru.springframework.recipeapp.model.Recipe;
import guru.springframework.recipeapp.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class IndexControlllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    IndexControlller indexControlller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        indexControlller = new IndexControlller(recipeService);
    }

    @Test
    void getIndexPage() throws Exception {
        //given
        List<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe());
        recipes.add(new Recipe());
        when(recipeService.findAll()).thenReturn(recipes);
        ArgumentCaptor<List<Recipe>> argumentCaptor = ArgumentCaptor.forClass(List.class);
        //when
        String viewName = indexControlller.getIndexPage(model);
        //then
        assertEquals("index",viewName);
        verify(recipeService,times(1)).findAll();
        verify(model,times(1)).addAttribute(eq("recipes"),argumentCaptor.capture());
        List<Recipe> listInController = argumentCaptor.getValue();
        assertEquals(2,listInController.size());
    }
}