package com.springframework.recipeapp.repository;

import com.springframework.recipeapp.model.UnitOfMeasure;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryTest {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Test
    public void findByUom() {

        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByUom("Teaspoon");
        assertEquals("Teaspoon", unitOfMeasure.get().getUom());
    }

    @Test(expected = NoSuchElementException.class)
    public void findByUom_shouldReturnNoSuchElementException() {
        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByUom("Not Found");
        assertEquals("Not Found", unitOfMeasure.get().getUom());
    }
}