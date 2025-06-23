package com.merzmostafaei.store.mappers;

import com.merzmostafaei.store.dtos.ProductDto;
import com.merzmostafaei.store.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

//Building Product EndPoints
@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "categoryId", source = "category.id")
    ProductDto toDto(Product product);
}
