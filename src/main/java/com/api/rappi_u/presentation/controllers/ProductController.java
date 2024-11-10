package com.api.rappi_u.presentation.controllers;


import com.api.rappi_u.application.usecases.ProductService;
import com.api.rappi_u.domain.entities.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Product", description = "Product controller")
@RestController
@RequestMapping("/product")
public class ProductController {


    @Autowired
    private ProductService productService;


    @Operation(summary = "Obtener los productos", description = "Obtiene todos los productos")
    @GetMapping
    List<Product> getAllProducts() {
        return productService.getAllProducts();
    }


    @Operation(summary = "Obtener los productos de tienda", description = "Obtiene todos los productos de cierta tienda")
    @GetMapping("/{idShop}")
    List<Product> getShopProducts(@PathVariable("idShop") @Parameter(description = "Id de la tienda") Long idShop) {
        return productService.getShopProducts(idShop);
    }


}
