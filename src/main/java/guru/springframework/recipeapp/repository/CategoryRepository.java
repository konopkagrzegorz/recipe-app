package guru.springframework.recipeapp.repository;

import guru.springframework.recipeapp.model.Category;
import guru.springframework.recipeapp.model.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category,Long> {

    //Optional<Category> findByDescription(String description);

}
