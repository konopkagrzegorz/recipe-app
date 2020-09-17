package com.springframework.recipeapp.services;

import com.springframework.recipeapp.model.Recipe;
import com.springframework.recipeapp.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService {

    private RecipeRepository recipeRepository;

    @Autowired
    public ImageServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void saveImage(Long recipeId, MultipartFile file) {
        try {
            Recipe recipe = recipeRepository.findById(recipeId).get();
            Byte[] byteObjects = new Byte[file.getBytes().length];
            int i = 0;
            for (byte b : file.getBytes()){
                byteObjects[i++] = b;
            }
            recipe.setImage(byteObjects);
            recipeRepository.save(recipe);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
