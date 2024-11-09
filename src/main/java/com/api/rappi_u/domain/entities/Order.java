package com.api.rappi_u.domain.entities;

import com.api.rappi_u.domain.Enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "Orders")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
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
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "observations")
    private String observations;

}
