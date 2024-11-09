package com.api.rappi_u.presentation.controllers;


import com.api.rappi_u.application.usecases.ShopService;
import com.api.rappi_u.domain.entities.Shop;
import com.api.rappi_u.infrastructure.persistence.JpaShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/shop")
public class ShopController {


    @Autowired
    private ShopService shopService;
    @Autowired
    private JpaShopRepository jpaShopRepository;


    @GetMapping
    List<Shop> getAllShops() {
        return jpaShopRepository.findAll();
    }

}
