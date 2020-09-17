package com.springframework.recipeapp.validation;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {


    private String firstValue;
    private String secondValue;


    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        Object firstValueObj = new BeanWrapperImpl(value).getPropertyValue(firstValue);
        Object secondValueObj = new BeanWrapperImpl(value).getPropertyValue(secondValue);

        if (firstValueObj != null) {
            return secondValueObj.equals(firstValueObj);
        }
        return secondValueObj == null;
    }

    @Override
    public void initialize(FieldMatch constraintAnnotation) {
        this.firstValue = constraintAnnotation.firstValue();
        this.secondValue = constraintAnnotation.secondValue();

    }
}
