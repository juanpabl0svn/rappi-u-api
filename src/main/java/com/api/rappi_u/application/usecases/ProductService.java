package com.api.rappi_u.application.usecases;


import com.api.rappi_u.domain.entities.Product;
import com.api.rappi_u.domain.entities.Shop;
import com.api.rappi_u.infrastructure.persistence.JpaProductRepository;
import com.api.rappi_u.infrastructure.persistence.JpaShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {


    @Autowired
    private JpaProductRepository jpaProductRepository;

    @Autowired
    private JpaShopRepository jpaShopRepository;

    public List<Product> getAllProducts() {
        return jpaProductRepository.findAll();
    }


    public List<Product> getShopProducts(Long idShop) {
        try {
            Shop shop = jpaShopRepository.findById(idShop).orElseThrow(() -> new Exception("Shop not found"));
            return jpaProductRepository.findAllByShop(shop);
        } catch (Exception e) {
            return List.of();
        }
    }
}
