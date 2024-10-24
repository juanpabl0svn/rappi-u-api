package com.rappi_u.rappi_u.repositories;

import com.rappi_u.rappi_u.models.ProductsCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface
ProductsCategoryRepository extends JpaRepository<ProductsCategory,Long> {
}
