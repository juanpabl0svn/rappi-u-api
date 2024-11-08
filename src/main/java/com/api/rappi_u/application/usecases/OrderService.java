package com.api.rappi_u.application.usecases;


import com.api.rappi_u.domain.entities.Order;
import com.api.rappi_u.domain.entities.User;
import com.api.rappi_u.infrastructure.persistence.JpaOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private JpaOrderRepository jpaOrderRepository;


    public List<Order> getAllOrder() {
        return jpaOrderRepository.findAll();
    }


}
