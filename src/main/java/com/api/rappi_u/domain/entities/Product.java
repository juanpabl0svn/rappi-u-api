package com.api.rappi_u.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long idProduct;

    @ManyToOne
    @JoinColumn(name = "id_shop")
    private Shop shop;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "available")
    private Boolean available;

    @Column(name = "image")
    private String image;

}
