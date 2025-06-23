package com.merzmostafaei.store.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

//--Create Resources
@Data

public class RegisterUserRequest {
    //--Jakarta Validation
    @NotBlank(message = "Name is requierd") //"", " "
    @Size(max = 255, message = "less that 255 charachters")
    private String name;
    //--Jakarta Validation
    @NotBlank(message = "Email Requierd")
    @Email(message = "Email must be valid")
    private String email;
    //--Jakarta Validation
    @NotBlank(message = "Password is required")
    @Size(min = 6,max = 25, message = "Password must be at least 6 to 25 characters Long")
    private String password;
}
