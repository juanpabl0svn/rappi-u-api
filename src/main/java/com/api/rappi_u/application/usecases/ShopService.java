package com.api.rappi_u.application.usecases;

import com.api.rappi_u.domain.entities.Shop;
import com.api.rappi_u.infrastructure.persistence.JpaShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService {

    @Autowired
    private JpaShopRepository jpaShopRepository;


    public List<Shop> getAllShops(){
        return jpaShopRepository.findAll();
    }


    public Optional<Shop> getShop(Long id){
        return jpaShopRepository.findById(id);
    }


}
