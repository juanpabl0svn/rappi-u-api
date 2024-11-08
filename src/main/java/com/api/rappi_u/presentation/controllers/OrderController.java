package com.api.rappi_u.presentation.controllers;

import com.api.rappi_u.application.usecases.OrderService;
import com.api.rappi_u.domain.entities.Delivery;
import com.api.rappi_u.domain.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/order")
public class OrderController {


    @Autowired
    private OrderService orderService;


    @GetMapping
    public List<Order> getAllDeliverys() {
        return orderService.getAllOrder();
    }


}
