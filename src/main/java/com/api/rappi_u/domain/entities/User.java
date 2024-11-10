package com.api.rappi_u.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "Users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "first_name")
    @NotEmpty(message = "firstName is required")
    private String firstName;

    @NotEmpty(message = "lastName is requiered")
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "cc", unique = true)
    @NotEmpty(message = "cc ir required")
    private String cc;

    @Column(name = "email", unique = true)
    @Email(message = "email is invalid")
    @NotEmpty(message = "email is required")
    private String email;

    @Column(name = "password")
    @NotEmpty(message = "password is required")
    private String password;

}
