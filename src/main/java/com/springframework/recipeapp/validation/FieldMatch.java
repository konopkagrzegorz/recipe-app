package com.springframework.recipeapp.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FieldMatchValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldMatch {

    String message() default "Field's doesn't match";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String firstValue();
    String secondValue();

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List
    {
        FieldMatch[] value();
    }

}
