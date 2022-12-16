package com.codestates.coffee;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CorrectPriceValidator implements ConstraintValidator<CorrectPrice, Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value == 0 || (100 <= value && value <= 50000);
    }

    @Override
    public void initialize(CorrectPrice constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
