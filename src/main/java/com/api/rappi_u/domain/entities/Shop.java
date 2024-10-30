package com.api.rappi_u.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Shops")
@Data
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_shop")
    private Long idShop;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private String image_url;



    // Getters y Setters
}
