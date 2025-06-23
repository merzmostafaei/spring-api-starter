package com.merzmostafaei.store.mappers;

import com.merzmostafaei.store.dtos.ProductDto;
import com.merzmostafaei.store.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;



//Building Product EndPoints
@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "categoryId", source = "category.id")
    ProductDto toDto(Product product);


    //Building A Crud API ->Create-Update-Delete Product
    Product toEntity(ProductDto productDto);

    //for UpdateProduct
    @Mapping(target = "id",ignore = true)  //because here we have id as a field not in the body so we ignore this fild
    void update(ProductDto productDto,@MappingTarget Product product);
}