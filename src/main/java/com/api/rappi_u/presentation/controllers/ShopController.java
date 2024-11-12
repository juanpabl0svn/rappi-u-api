package com.api.rappi_u.presentation.controllers;


import com.api.rappi_u.application.usecases.ShopService;
import com.api.rappi_u.domain.entities.Shop;
import com.api.rappi_u.infrastructure.persistence.JpaShopRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/shop")
@Tag(name = "Shop", description = "Shop controller")
public class ShopController {


    @Autowired
    private ShopService shopService;
    @Autowired
    private JpaShopRepository jpaShopRepository;


    @Operation(summary = "Obtener tiendas", description = "Obtener todas las tiendas")
    @GetMapping
    List<Shop> getAllShops() {
        return shopService.getAllShops();
    }

    @Operation(summary = "Obtener la tienda", description = "Obtener la tienda por medio de Id")
    @GetMapping("/{id}")
    Optional<Shop> getShop(@PathVariable("id") @Parameter(description = "Id de la tienda") Long id) {
        return shopService.getShop(id);
    }

}
