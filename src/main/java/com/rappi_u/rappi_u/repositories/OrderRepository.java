package com.rappi_u.rappi_u.repositories;

import com.rappi_u.rappi_u.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
