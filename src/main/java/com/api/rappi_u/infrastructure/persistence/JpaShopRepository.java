package com.api.rappi_u.infrastructure.persistence;

import com.api.rappi_u.domain.entities.Shop;
import com.api.rappi_u.domain.repositories.ShopRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JpaShopRepository extends JpaRepository<Shop, Long>, ShopRepository {


}
