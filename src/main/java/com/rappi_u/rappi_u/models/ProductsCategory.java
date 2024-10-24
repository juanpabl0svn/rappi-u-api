package com.rappi_u.rappi_u.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "ProductsCategory")
public class ProductsCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pc_id;

    @OneToMany
    @JoinColumn(name = "products_id")
    private List<Product> products;

    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Category> categories;
}
