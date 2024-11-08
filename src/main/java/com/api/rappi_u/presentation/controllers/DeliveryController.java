package com.api.rappi_u.presentation.controllers;

import com.api.rappi_u.application.usecases.DeliveryService;
import com.api.rappi_u.domain.entities.Delivery;
import com.api.rappi_u.infrastructure.dto.LoginDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;


    @GetMapping
    public List<Delivery> getAllDeliverys() {
        return deliveryService.getAllDeliveries();
    }

    @PostMapping("/register")
    public Delivery register(@Valid @RequestBody Delivery user) {
        return deliveryService.register(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> logIn(@Valid @RequestBody LoginDto login) {
        return deliveryService.logIn(login.getEmail(), login.getPassword());
    }
}
