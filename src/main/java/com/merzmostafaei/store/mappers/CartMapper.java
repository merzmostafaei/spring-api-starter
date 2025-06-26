package com.merzmostafaei.store.mappers;

import com.merzmostafaei.store.dtos.CartDto;
import com.merzmostafaei.store.dtos.CartItemDto;
import com.merzmostafaei.store.entities.Cart;
import com.merzmostafaei.store.entities.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

//-- Creating A cart API
@Mapper(componentModel = "spring")
public interface CartMapper {

    //--Getting The Cart
    //implimenting End Poit To getting the Cart
    @Mapping(target = "items",source = "items") //-> so don't need configuration because sorce and code are same
    @Mapping(target = "totalPrice", expression = "java(cart.getTotalPrice())")
    CartDto toDto(Cart cart);
    //ADDING A Product TO the Cart //mapping
    @Mapping(target = "totalPrice",expression ="java(cartItem.getTotalPrice())" ) //we use expression because we don' have source fild
    CartItemDto toDto(CartItem cartItem);


}
