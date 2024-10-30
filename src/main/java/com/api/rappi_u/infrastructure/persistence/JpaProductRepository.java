package com.api.rappi_u.infrastructure.persistence;

import com.api.rappi_u.domain.entities.Product;
import com.api.rappi_u.domain.repositories.ProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProductRepository extends JpaRepository<Product, Long>, ProductRepository {
}
