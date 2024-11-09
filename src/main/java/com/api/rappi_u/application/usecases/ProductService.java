package com.api.rappi_u.application.usecases;


import com.api.rappi_u.domain.entities.Product;
import com.api.rappi_u.infrastructure.persistence.JpaProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {


    @Autowired
    private JpaProductRepository jpaProductRepository;

    public List<Product> getAllProducts(){
        return jpaProductRepository.findAll();
    }
}
