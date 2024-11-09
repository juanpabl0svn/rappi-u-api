package com.api.rappi_u.infrastructure.persistence;

import com.api.rappi_u.domain.entities.Delivery;
import com.api.rappi_u.domain.entities.Order;
import com.api.rappi_u.domain.Enums.OrderStatus;
import com.api.rappi_u.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaOrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByStatus(OrderStatus status);

    List<Order> findByUser(User user);

    List<Order> findByDeliveryAndStatus(Delivery delivery, OrderStatus status);


}
