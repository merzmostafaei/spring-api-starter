package com.merzmostafaei.store.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

// ConstraintValidator<customAnnotation, TypeofDataWeGoToApply> is generic interface
public class LowercaseValidator implements ConstraintValidator<Lowercase, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value ==null) return true; //because string is nullable
        return value.equals(value.toLowerCase()); // if this true means value is lowercase
    }
}
