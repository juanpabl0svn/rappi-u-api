package com.rappi_u.rappi_u.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="`Categories`")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_id;

    private String category_name;

}
