package com.merzmostafaei.store.mappers;

import com.merzmostafaei.store.dtos.CartDto;
import com.merzmostafaei.store.entities.Cart;
import org.mapstruct.Mapper;

//-- Creating A cart API
@Mapper(componentModel = "spring")
public interface CartMapper {

    CartDto toDto(Cart cart);
}
