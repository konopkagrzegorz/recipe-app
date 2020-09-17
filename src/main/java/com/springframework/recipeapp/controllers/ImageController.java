package com.springframework.recipeapp.controllers;

import com.springframework.recipeapp.model.Recipe;
import com.springframework.recipeapp.services.ImageService;
import com.springframework.recipeapp.services.RecipeService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class ImageController {

    private RecipeService recipeService;
    private ImageService imageService;

    @Autowired
    public ImageController(RecipeService recipeService, ImageService imageService) {
        this.recipeService = recipeService;
        this.imageService = imageService;
    }

    @GetMapping("/recipes/show/{recipeId}/image")
    public String showImageForm(@PathVariable ("recipeId") Long recipeId, Model model) {
        model.addAttribute("recipe", recipeService.findById(recipeId));
        return "recipe/imageupload-form";
    }

    @PostMapping("recipes/show/{id}/image/upload")
    public String handleImagePost(@PathVariable Long id, @RequestParam("imagefile") MultipartFile file) {
        imageService.saveImage(id, file);
        return "redirect:/recipes/show/" + id;
    }

    @GetMapping("recipes/show/{id}/recipeimage")
    public void renderImageFromDB(@PathVariable Long id, HttpServletResponse response) throws IOException {
        Recipe recipe = recipeService.findById(id);

        if (recipe.getImage() != null) {
            byte[] byteArray = new byte[recipe.getImage().length];
            int i = 0;

            for (Byte wrappedByte : recipe.getImage()){
                byteArray[i++] = wrappedByte; //auto unboxing
            }

            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArray);
            IOUtils.copy(is, response.getOutputStream());
        }
    }
}
