package com.merzmostafaei.store.controllers;


import com.merzmostafaei.store.dtos.CartDto;
import com.merzmostafaei.store.dtos.CartItemDto;
import com.merzmostafaei.store.dtos.addItemToCartRequest;
import com.merzmostafaei.store.entities.Cart;
import com.merzmostafaei.store.entities.CartItem;
import com.merzmostafaei.store.mappers.CartMapper;
import com.merzmostafaei.store.repositories.CartRepository;
import com.merzmostafaei.store.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

//-- Creating A cart API
@AllArgsConstructor
@RestController
@RequestMapping("/carts")
public class CartController {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;
    private final ProductRepository productRepository;


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

    //--ADDING A Product TO the Cart
    @PostMapping("/{cartId}/items")
    public ResponseEntity<CartItemDto> addToCart(
            @PathVariable UUID cartId,
            @RequestBody addItemToCartRequest request
    )
    {

        //makeSure CartId is Valid error 404
        var cart = cartRepository.getCartWithItems(cartId).orElse(null); //Clean the unnecessary queries replace findby to getCartWithItems(cartId)
        if(cart == null){
            return ResponseEntity.notFound().build();
        }
        //validate the productId error badRequest
        var product = productRepository.findById(request.getProductId()).orElse(null);
        if(product == null){
            return ResponseEntity.badRequest().build();
        }
        // if we don't have this product doesn't exist in the cart we must add it, if exist we must increment the quantity

        var cartItem = cart.getItems().stream()
                .filter(item -> item.getProduct().getId().equals(product.getId()))
                .findFirst()
                .orElse(null);
        if(cartItem != null){
            cartItem.setQuantity(cartItem.getQuantity()+1);
        }
        else{
            cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setQuantity(1);
            //associate cart
            cartItem.setCart(cart);
            //add to collection the card Object
            cart.getItems().add(cartItem);
        }
        cartRepository.save(cart);

        //ADDING A Product TO the Cart //mapping
        var cartItemDto = cartMapper.toDto(cartItem);

        return ResponseEntity.status(HttpStatus.CREATED).body(cartItemDto);
    }

    //--Getting The Cart
    //implimenting End Poit To getting the Cart
    @GetMapping("/{cartId}")
    public ResponseEntity<CartDto> getCart(@PathVariable UUID cartId){
        var cart = cartRepository.getCartWithItems(cartId).orElse(null);////Clean the unnecessary queries replace findby to getCartWithItems(cartId)
        if ( cart == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cartMapper.toDto(cart));
    }
}
