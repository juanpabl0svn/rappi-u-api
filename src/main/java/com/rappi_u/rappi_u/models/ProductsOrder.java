package com.rappi_u.rappi_u.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "`ProductsOrder`")
public class ProductsOrder {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long po_id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private  Order order_id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product_id;

    private Integer quantity;






}
