package com.merzmostafaei.store.validation;





import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Implementing Custom Validation
@Target(ElementType.FIELD)              //espacify where we gonna apply this annotation
@Retention(RetentionPolicy.RUNTIME)     //where this annotation is apply
@Constraint(validatedBy = LowercaseValidator.class) //provide name of the validator class
public @interface Lowercase {
    String message() default "must be lowercasse"; //define message Attribute
    //add 2more Attribute

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
