package com.rappi_u.rappi_u.repositories;

import com.rappi_u.rappi_u.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
