package com.rappi_u.rappi_u.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "`Shops`")
public class Shop {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shop_id;

    private String name;

    private String description;
}
