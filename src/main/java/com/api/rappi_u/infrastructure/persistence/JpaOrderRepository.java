package com.api.rappi_u.infrastructure.persistence;

import com.api.rappi_u.domain.entities.Delivery;
import com.api.rappi_u.domain.entities.Order;
import com.api.rappi_u.domain.Enums.OrderStatus;
import com.api.rappi_u.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface JpaOrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByStatus(OrderStatus status);

    List<Order> findByUser(User user);

    List<Order> findByDelivery(Delivery delivery);

    List<Order> findByTotalGreaterThan(BigDecimal amount);

    List<Order> findByStatusAndTotalGreaterThan(OrderStatus status, BigDecimal amount);

    Long countByStatus(OrderStatus status);

    List<Order> findByObservationsIsNotNull();
}
