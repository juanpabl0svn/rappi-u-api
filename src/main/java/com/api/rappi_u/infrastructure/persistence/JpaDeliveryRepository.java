package com.api.rappi_u.infrastructure.persistence;

import com.api.rappi_u.domain.entities.Delivery;
import com.api.rappi_u.domain.repositories.DeliveryRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaDeliveryRepository extends JpaRepository<Delivery, Long>, DeliveryRepository {

    Optional<Delivery> findByEmail(String email);
}
