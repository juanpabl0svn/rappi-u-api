package com.api.rappi_u.application.usecases;

import com.api.rappi_u.domain.entities.Shop;
import com.api.rappi_u.infrastructure.persistence.JpaShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    @Autowired
    private JpaShopRepository jpaShopRepository;


    List<Shop> getAllShops(){
        return jpaShopRepository.findAll();
    }


}
