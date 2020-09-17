package com.springframework.recipeapp.services;

import com.springframework.recipeapp.model.UnitOfMeasure;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UnitOfMeasureService {

     List<UnitOfMeasure> findAll();

     Optional<UnitOfMeasure> findByUom(String uom);

     void save(UnitOfMeasure uom);

     void deleteById(Long id);
}
