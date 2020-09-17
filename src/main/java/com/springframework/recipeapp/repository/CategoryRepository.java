package com.springframework.recipeapp.repository;

import com.springframework.recipeapp.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {

}
