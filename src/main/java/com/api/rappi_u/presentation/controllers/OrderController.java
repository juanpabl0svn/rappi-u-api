package com.api.rappi_u.presentation.controllers;

import com.api.rappi_u.application.usecases.OrderService;
import com.api.rappi_u.domain.entities.Delivery;
import com.api.rappi_u.domain.entities.Order;
import com.api.rappi_u.infrastructure.dto.OrderDto;
import com.api.rappi_u.infrastructure.dto.SelectOrderDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/order")
@Tag(name = "Order", description = "Order controller" )
public class OrderController {


    @Autowired
    private OrderService orderService;


    @Operation(summary = "Obtener ordenes", description = "Obtener todas las ordenes" )
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }


    @Operation(summary = "Dar orden a repartidor", description = "Se le asigna una orden a un repartidor")
    @PostMapping("/set-delivery")
    public ResponseEntity<?> setDelivery(@Valid @RequestBody @Parameter(description = "ïd de la orden y del repartidor" ) SelectOrderDto selectOrderDto) {
        return orderService.selectOrder(selectOrderDto);
    }

    @Operation(summary = "Obtener las ordenes pendientes ", description = "Ordenes sin repartidor")
    @GetMapping("/pending")
    public List<Order> getPendingOrders() {
        return orderService.getPendingOrders();
    }


    @Operation(summary = "Crear orden", description = "Retorna una nueva orden")
    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@Valid @RequestBody @Parameter(description = "Estructura para crear una orden") OrderDto order) {
        return orderService.createOrder(order);
    }

    @Operation(summary = "Obtener orden", description = "Retorna la orden por id")
    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable("id") @Parameter(description = "id de la orden") Long id) {
        return orderService.getOrder(id);
    }


    @Operation(summary = "Cancelar una orden", description = "Ahora la orden no es valida, cambia su estado a cancelled")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> cancelOrder(@PathVariable("id") @Parameter(description = "Id de la orden") Long id){

        return orderService.cancelOrder(id);

    }


}
