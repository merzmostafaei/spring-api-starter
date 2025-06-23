package com.merzmostafaei.store.dtos;

import lombok.Data;

import java.math.BigDecimal;

//Building Product EndPoints
@Data
public class ProductDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private Byte categoryId;
}
