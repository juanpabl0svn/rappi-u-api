package com.api.rappi_u.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Locations")
@Data
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_location")
    private Long idLocation;

    @Column(name = "location")
    private String location;

    // Getters y Setters
}
