package com.springframework.recipeapp.controllers;

import com.springframework.recipeapp.services.RecipeService;
import org.mockito.Mock;
import org.springframework.ui.Model;

import static org.mockito.ArgumentMatchers.eq;

class IndexControllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    IndexController indexControlller;

//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//        indexControlller = new IndexController(recipeService);
//    }
//
//    @Test
//    void getIndexPage() throws Exception {
//        //given
//        List<Recipe> recipes = new ArrayList<>();
//        recipes.add(new Recipe());
//        recipes.add(new Recipe());
//        when(recipeService.findAll()).thenReturn(recipes);
//        ArgumentCaptor<List<Recipe>> argumentCaptor = ArgumentCaptor.forClass(List.class);
//        //when
//        String viewName = indexControlller.getIndexPage(model);
//        //then
//        assertEquals("index",viewName);
//        verify(recipeService,times(1)).findAll();
//        verify(model,times(1)).addAttribute(eq("recipes"),argumentCaptor.capture());
//        List<Recipe> listInController = argumentCaptor.getValue();
//        assertEquals(2,listInController.size());
//    }
}