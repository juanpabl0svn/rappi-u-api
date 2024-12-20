package com.api.rappi_u.application.usecases;


import com.api.rappi_u.domain.Enums.OrderStatus;
import com.api.rappi_u.domain.entities.Delivery;
import com.api.rappi_u.domain.entities.Order;
import com.api.rappi_u.domain.entities.User;
import com.api.rappi_u.infrastructure.persistence.JpaDeliveryRepository;
import com.api.rappi_u.infrastructure.persistence.JpaOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {

    @Autowired
    private JpaDeliveryRepository jpaDeliveryRepository;

    @Autowired
    private JpaOrderRepository jpaOrderRepository;

    public List<Delivery> getAllDeliveries() {
        return jpaDeliveryRepository.findAll();
    }

    public Delivery register(Delivery delivery) {
        return jpaDeliveryRepository.save(delivery);
    }

    public ResponseEntity<?> logIn(String email, String password) {
        try {
            Delivery delivery = jpaDeliveryRepository.findByEmail(email).orElseThrow(() -> new Exception("Email or password are wrong"));
            if (!delivery.getPassword().equals(password)) {
                throw new Exception("Email or password are wrong");
            }
            return new ResponseEntity<>(delivery, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    public List<Order> getDeliveryOrders(Long id) {
        try {
            Delivery delivery = jpaDeliveryRepository.findById(id).orElseThrow(() -> new Exception("Delivery not found"));
            return jpaOrderRepository.findAllByDeliveryAndStatus(delivery, OrderStatus.onTheWay);
        } catch (Exception e) {
            return List.of();
        }
    }

    public Optional<Delivery> getDelivery(Long id){
        return jpaDeliveryRepository.findById(id);
    }

}
