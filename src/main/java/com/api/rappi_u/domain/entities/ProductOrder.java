package com.api.rappi_u.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Table(name = "ProductsOrder")
@Builder
@AllArgsConstructor
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_po;

    @ManyToOne
    @JoinColumn(name = "id_order", referencedColumnName = "id_order")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id_product")
    private Product product;

    private Integer quantity;
}
