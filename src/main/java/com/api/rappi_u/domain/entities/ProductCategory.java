package com.api.rappi_u.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ProductsCategory")
@Data
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pc")
    private Long idPc;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    // Getters y Setters
}

