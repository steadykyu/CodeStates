package com.codestates.coffee;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {CorrectPriceValidator.class})
public @interface CorrectPrice {
    String message() default "올바른 값을 입력해주세요";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
