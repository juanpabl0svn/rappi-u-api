package com.api.rappi_u.domain.repositories;

import com.api.rappi_u.domain.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
