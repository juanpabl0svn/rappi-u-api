package com.api.rappi_u.infrastructure.persistence;

import com.api.rappi_u.domain.entities.ProductCategory;
import com.api.rappi_u.domain.repositories.ProductCategoryRespository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProductCategoryRespository extends JpaRepository<ProductCategory, Long>, ProductCategoryRespository {
}
