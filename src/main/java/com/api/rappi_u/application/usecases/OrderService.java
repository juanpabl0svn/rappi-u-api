package com.api.rappi_u.application.usecases;


import com.api.rappi_u.domain.Enums.OrderStatus;
import com.api.rappi_u.domain.entities.*;
import com.api.rappi_u.infrastructure.dto.OrderDto;
import com.api.rappi_u.infrastructure.dto.ProductOrderDto;
import com.api.rappi_u.infrastructure.dto.SelectOrderDto;
import com.api.rappi_u.infrastructure.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private JpaOrderRepository jpaOrderRepository;

    @Autowired
    private JpaDeliveryRepository jpaDeliveryRepository;

    @Autowired
    private JpaUserRepository jpaUserRepository;

    @Autowired
    private JpaLocationRepository jpaLocationRepository;

    @Autowired
    private JpaProductOrderRepository jpaProductOrderRepository;

    @Autowired
    private JpaProductRepository jpaProductRepository;


    public List<Order> getAllOrders() {
        return jpaOrderRepository.findAll();
    }

    public List<Order> getPendingOrders() {
        return jpaOrderRepository.findByStatus(OrderStatus.pending);
    }

    public ResponseEntity<?> selectOrder(SelectOrderDto selectOrderDto) {
        try {

            Order order = jpaOrderRepository.findById(selectOrderDto.getIdOrder()).orElseThrow(() -> new Exception("Order not found"));

            Delivery delivery = jpaDeliveryRepository.findById(selectOrderDto.getIdDelivery()).orElseThrow(() -> new Exception("Delivery not found"));

            order.setDelivery(delivery);

            order.setStatus(OrderStatus.onTheWay);

            Order result = jpaOrderRepository.save(order);

            return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }


    }


    public ResponseEntity<?> getOrder(Long id) {

        try {

            Order order = jpaOrderRepository.findById(id).orElseThrow(() -> new Exception("Order not found"));

            List<ProductOrder> products = jpaProductOrderRepository.findByOrder(order);

            return new ResponseEntity<>(Map.of("products", products,
                    "order", order), HttpStatus.ACCEPTED);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }


    public ResponseEntity<?> createOrder(OrderDto order) {
        try {
            User user = jpaUserRepository.findById(order.getIdUser())
                    .orElseThrow(() -> new Exception("User not found"));
            Location location = jpaLocationRepository.findById(order.getIdLocation())
                    .orElseThrow(() -> new Exception("Location not found"));

            Order newOrder = Order.builder()
                    .status(OrderStatus.pending)
                    .total(order.getTotal())
                    .user(user)
                    .location(location)
                    .build();

            newOrder = jpaOrderRepository.save(newOrder);

            for (ProductOrderDto item : order.getProducts()) {
                Product product = jpaProductRepository.findById(item.getIdProduct())
                        .orElseThrow(() -> new Exception("Product not found"));

                ProductOrder productOrder = ProductOrder.builder()
                        .order(newOrder)
                        .product(product)
                        .quantity(item.getQuantity()) // Aquí aseguramos la cantidad
                        .build();

                jpaProductOrderRepository.save(productOrder);
            }

            return new ResponseEntity<>(newOrder, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    public ResponseEntity<?> cancelOrder(Long id) {
        try {
            Order order = jpaOrderRepository.findById(id).orElseThrow(() -> new Exception("Order not found"));
            order.setStatus(OrderStatus.cancelled);
            Order result = jpaOrderRepository.save(order);
            return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

}
