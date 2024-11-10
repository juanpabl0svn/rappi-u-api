package com.api.rappi_u.presentation.controllers;

import com.api.rappi_u.application.usecases.UserService;
import com.api.rappi_u.domain.entities.Order;
import com.api.rappi_u.domain.entities.User;
import com.api.rappi_u.infrastructure.dto.LoginDto;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/order/{id}")
    public List<Order> getUserOrders(@PathVariable("id") Long id){
        return userService.getUserOrders(id);
    }

    @PostMapping("/register")
    public User register(@Valid @RequestBody User user){
        return userService.register(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> logIn(@Valid @RequestBody LoginDto login){
        return userService.logIn(login.getEmail(),login.getPassword());
    }





}
