package com.api.rappi_u.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "firstName is required")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "lastName is required")
    private String lastName;

    @Column(name = "birthdate")
    @NotEmpty(message = "birthDate is required")
    private LocalDate birthDate;

    @Column(name = "cc", unique = true)
    @NotEmpty(message = "cc is required")
    private String cc;

    @Column(name = "email", unique = true)
    @NotEmpty(message = "email is required")
    @Email(message = "email is invalid")
    private String email;

    @Column(name = "password")
    @NotEmpty(message = "password is required")
    @Length(min = 4, max = 50)
    private String password;

}

