package com.api.rappi_u.infrastructure.persistence;

import com.api.rappi_u.domain.entities.Order;
import com.api.rappi_u.domain.repositories.OrderRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaOrderRepository extends JpaRepository<Order,Long>, OrderRepository {
}
