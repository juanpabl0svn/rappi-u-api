package com.api.rappi_u.presentation.controllers;


import com.api.rappi_u.application.usecases.ProductService;
import com.api.rappi_u.domain.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {


    @Autowired
    private ProductService productService;


    @GetMapping
    List<Product> getAllProducts(){
        return productService.getAllProducts();
    }





}
