package com.rappi_u.rappi_u.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "`Locations`")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long location_id;

    private String location;
}
