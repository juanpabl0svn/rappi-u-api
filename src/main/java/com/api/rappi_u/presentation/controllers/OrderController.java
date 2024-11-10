package com.api.rappi_u.presentation.controllers;

import com.api.rappi_u.application.usecases.OrderService;
import com.api.rappi_u.domain.entities.Delivery;
import com.api.rappi_u.domain.entities.Order;
import com.api.rappi_u.infrastructure.dto.OrderDto;
import com.api.rappi_u.infrastructure.dto.SelectOrderDto;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/order")
public class OrderController {


    @Autowired
    private OrderService orderService;


    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }


    @PostMapping("/set-delivery")
    public ResponseEntity<?> setDelivery(@Valid @RequestBody SelectOrderDto selectOrderDto) {
        return orderService.selectOrder(selectOrderDto);
    }

    @GetMapping("/pending")
    public List<Order> getPendingOrders() {
        return orderService.getPendingOrders();
    }


    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@Valid @RequestBody OrderDto order) {
        return orderService.createOrder(order);
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable("id") Long id) {
        return orderService.getOrder(id);
    }


}
