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

    private Double total;


    @OneToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery_id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    @Enumerated(EnumType.STRING)
    private OrderState state;

    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location_id;

    private String observation;
}
