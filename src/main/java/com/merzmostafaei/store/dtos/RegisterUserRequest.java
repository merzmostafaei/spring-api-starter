package com.merzmostafaei.store.dtos;

import lombok.Data;

//--Create Resources
@Data
public class RegisterUserRequest {
    private String name;
    private String email;
    private String password;
}
