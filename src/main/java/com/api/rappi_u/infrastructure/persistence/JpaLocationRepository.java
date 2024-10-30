package com.api.rappi_u.infrastructure.persistence;

import com.api.rappi_u.domain.entities.Location;
import com.api.rappi_u.domain.repositories.LocationRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JpaLocationRepository extends JpaRepository<Location, Long>, LocationRepository {
}
