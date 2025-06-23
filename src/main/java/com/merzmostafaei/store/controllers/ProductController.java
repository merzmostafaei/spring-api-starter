package com.merzmostafaei.store.controllers;

import com.merzmostafaei.store.dtos.ProductDto;
import com.merzmostafaei.store.entities.Product;
import com.merzmostafaei.store.mappers.ProductMapper;
import com.merzmostafaei.store.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//Building Product EndPoints
@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @GetMapping
    public List<ProductDto> getAllProducts(@RequestParam(name="categoryid",required = false) Byte categoryId)
    {
        // for filetring by category we must to make the method in repository
        List<Product> products;
        if(categoryId != null){
            products = productRepository.findByCategoryId(categoryId);
        }
        else{
            products = productRepository.findAllWithCategory();
        }
        return products
                .stream()
                .map(productMapper::toDto)
                .toList();
    }
}
