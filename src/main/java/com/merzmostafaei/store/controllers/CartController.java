package com.merzmostafaei.store.controllers;


import com.merzmostafaei.store.dtos.CartDto;
import com.merzmostafaei.store.entities.Cart;
import com.merzmostafaei.store.mappers.CartMapper;
import com.merzmostafaei.store.repositories.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

//-- Creating A cart API
@AllArgsConstructor
@RestController
@RequestMapping("/carts")
public class CartController {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;


    @PostMapping
    public ResponseEntity<CartDto> createCart(
            UriComponentsBuilder uriBuilder
    ){
        var cart = new Cart();
        //save cart in repo
        cartRepository.save(cart);
        //map it to cartDto
        var cartDto = cartMapper.toDto(cart);

        //Return without Locate uri in header
        //return new ResponseEntity<>(cartDto, HttpStatus.CREATED);

        //--Return with uri location
        var uri = uriBuilder.path("/carts/{id}").buildAndExpand(cartDto.getId()).toUri();
        return ResponseEntity.created(uri).body(cartDto);
    }
}
