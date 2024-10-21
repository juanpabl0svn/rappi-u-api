package com.rappi_u.rappi_u.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="`User`")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
}
