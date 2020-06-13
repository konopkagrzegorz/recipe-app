package guru.springframework.recipeapp.services;

import guru.springframework.recipeapp.model.UnitOfMeasure;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UnitOfMeasureService {

     List<UnitOfMeasure> findAll();

     Optional<UnitOfMeasure> findByUom(String uom);

     void save(UnitOfMeasure uom);

     void deleteById(Long id);
}
