package com.merzmostafaei.store.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//-- Creating A cart API
@Data
public class CartDto {

    private UUID id;
    private List<CartItemDto> items = new ArrayList<>(); //to not null in response add new arraulist
    private BigDecimal totalPrice = BigDecimal.ZERO;     //to not null in response add .zero
}
