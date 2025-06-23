package com.merzmostafaei.store.dtos;

import lombok.Data;

//--UpdatingResources
@Data
public class UpdateUserRequest {
    public String name;
    public String email;
}
