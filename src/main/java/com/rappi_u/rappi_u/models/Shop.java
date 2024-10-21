package com.rappi_u.rappi_u.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Shop {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
