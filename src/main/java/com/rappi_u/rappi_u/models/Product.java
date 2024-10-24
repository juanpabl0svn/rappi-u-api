package com.rappi_u.rappi_u.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "`Products`")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    @OneToOne
    @JoinColumn(name = "shop_id")
    private Shop shop_id;

    private String name;

    private Double price;

    private String image;








}
