package com.merzmostafaei.store.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice //for exception logic for one of our Controller
public class GlobalExceptionHandler {
    //--Havind Validation Errors
    //@ExceptionHandler(Exception.class) --> for All Exceotion.
    //change the Return type Map(String,String) because we have fild "name" = "Name is requierd" in getMessage Error and we want to show it not more details error
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handlevalidationErrors(
            MethodArgumentNotValidException exception
    ){
        //we Create the Map
        var errors = new HashMap<String,String>();
        exception.getBindingResult().getFieldErrors().forEach(error ->{
            errors.put(error.getField(),error.getDefaultMessage());
        } );

        return ResponseEntity.badRequest().body(errors);
    }

}
