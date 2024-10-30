package com.api.rappi_u.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "Orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long idOrder;

    @ManyToOne
    @JoinColumn(name = "id_delivery")
    private Delivery delivery;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_location")
    private Location location;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "status")
    private String status;

    @Column(name = "observations")
    private String observations;

    // Getters y Setters
}
