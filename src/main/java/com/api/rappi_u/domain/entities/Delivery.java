package com.api.rappi_u.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "Deliveries")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_delivery")
    private Long idDelivery;

    @Column(name = "first_name")
    @NotNull(message = "firstName is required")
    @NotEmpty(message = "firstName is empty")

    private String firstName;

    @Column(name = "last_name")
    @NotNull(message = "lastName is required")
    @NotEmpty(message = "lastName is empty")
    private String lastName;


    @Column(name = "cc", unique = true)
    @NotNull(message = "cc is required")
    @NotEmpty(message = "cc is empty")
    private String cc;

    @Column(name = "email", unique = true)
    @NotNull(message = "email is required")
    @Email(message = "email is invalid")
    private String email;

    @Column(name = "password")
    @NotNull(message = "password is required")
    @NotEmpty(message = "password is empty")
    @Length(min = 4, max = 50)
    private String password;

}

