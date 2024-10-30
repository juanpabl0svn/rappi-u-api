package com.api.rappi_u.infrastructure.persistence;

import com.api.rappi_u.domain.entities.Category;
import com.api.rappi_u.domain.repositories.CategoryRespository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCategoryRespository extends JpaRepository<Category, Long>, CategoryRespository {
}
