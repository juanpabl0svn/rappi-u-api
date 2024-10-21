package com.rappi_u.rappi_u.models;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="`Deliveries`")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long delivery_id;

    private String delivery_name;
    private String delivery_email;
}
