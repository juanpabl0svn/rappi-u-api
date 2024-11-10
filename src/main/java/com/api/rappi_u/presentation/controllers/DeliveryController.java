package com.api.rappi_u.presentation.controllers;

import com.api.rappi_u.application.usecases.DeliveryService;
import com.api.rappi_u.domain.entities.Delivery;
import com.api.rappi_u.domain.entities.Order;
import com.api.rappi_u.infrastructure.dto.LoginDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/delivery")
@Tag(name = "Delivery", description = "Delivery controller")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;


    @Operation(summary = "Obtener repartidores", description = "Retorna a todos los repartidores")
    @GetMapping
    public List<Delivery> getAllDeliverys() {
        return deliveryService.getAllDeliveries();
    }

    @Schema()
    @Operation(summary = "Obtener ordenes de repartidor", description = "Retorna todas las ordenes que tiene un repartidos")
    @GetMapping("/orders/{id}")
    public List<Order> getDeliveryOrders(@PathVariable("id") @Parameter(description = "Id del repartidor") Long id) {
        return deliveryService.getDeliveryOrders(id);
    }

    @Operation(summary = "Crear repartidor", description = "Crea un repartidor")

    @PostMapping("/register")
    public Delivery register(@Valid @RequestBody @Parameter(description = "Valores del repartidor") Delivery user) {
        return deliveryService.register(user);
    }

    @Operation(summary = "Logearse como repartidor", description = "Retorna la información del repartidor")
    @PostMapping("/login")
    public ResponseEntity<?> logIn(@Valid @RequestBody LoginDto login) {
        return deliveryService.logIn(login.getEmail(), login.getPassword());
    }

}
