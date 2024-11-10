package com.api.rappi_u.presentation.controllers;

import com.api.rappi_u.application.usecases.UserService;
import com.api.rappi_u.domain.entities.Order;
import com.api.rappi_u.domain.entities.User;
import com.api.rappi_u.infrastructure.dto.LoginDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
@Tag(name = "User", description = "User controller")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Obtener usuarios", description = "Retorna todos los usuarios")
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @Operation(summary = "Obtener ordenes de usuario", description = "Obtener todas las ordenes de un usuario")
    @GetMapping("/order/{id}")
    public List<Order> getUserOrders(@PathVariable("id") @Parameter(description = "Id del usuario") Long id){
        return userService.getUserOrders(id);
    }

    @Operation(summary = "Registrar usuario", description = "Retorna el usuario creado")
    @PostMapping("/register")
    public User register(@Valid @RequestBody @Parameter(description = "Datos del usuario") User user){
        return userService.register(user);
    }

    @Operation(summary = "Iniciar sesión como usuario", description = "Retorna el usuario logeado")
    @PostMapping("/login")
    public ResponseEntity<?> logIn(@Valid @RequestBody LoginDto login){
        return userService.logIn(login.getEmail(),login.getPassword());
    }





}
