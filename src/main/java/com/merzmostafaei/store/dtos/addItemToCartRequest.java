package com.merzmostafaei.store.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;


//--ADDING A Product TO the Cart
@Data
public class addItemToCartRequest {

    @NotNull
    private Long productId;

}
