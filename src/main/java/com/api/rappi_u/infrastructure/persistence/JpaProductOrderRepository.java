package com.api.rappi_u.infrastructure.persistence;

import com.api.rappi_u.domain.entities.ProductOrder;
import com.api.rappi_u.domain.repositories.ProductOrderRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProductOrderRepository extends JpaRepository<ProductOrder, Long>, ProductOrderRepository {
}
