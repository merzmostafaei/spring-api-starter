package com.merzmostafaei.store.dtos;


import lombok.Data;

import java.math.BigDecimal;

//-- Creating A cart API
@Data
public class CartItemDto {

    //ADDING A Product TO the Cart  //Mapping
    private CartProductDto product;
    private int quantity;
    private BigDecimal totalPrice;
}
