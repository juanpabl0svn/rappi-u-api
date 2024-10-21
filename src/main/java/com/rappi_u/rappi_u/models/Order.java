package com.rappi_u.rappi_u.models;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "`Orders`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;

    private Long delivery_id;

    private Long user_id;

    private Double total;


    @OneToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;


}
