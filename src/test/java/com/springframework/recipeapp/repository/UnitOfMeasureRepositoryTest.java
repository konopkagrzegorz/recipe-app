package com.springframework.recipeapp.repository;

import com.springframework.recipeapp.model.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class UnitOfMeasureRepositoryTest {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @BeforeEach
    void setUp() {

    }

    @Test
    void findByUom() throws Exception {

        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByUom("Teaspoon");
        assertEquals("Teaspoon", unitOfMeasure.get().getUom());

    }
}