package com.merzmostafaei.store.dtos;

import lombok.Data;

//Action-Based Updates->ChangePassword
@Data
public class ChangePasswordRequest {
    private String oldPassword;
    private String newPassword;
}
