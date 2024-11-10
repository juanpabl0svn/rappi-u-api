package com.api.rappi_u.application.usecases;


import com.api.rappi_u.domain.entities.Order;
import com.api.rappi_u.domain.entities.User;
import com.api.rappi_u.infrastructure.persistence.JpaOrderRepository;
import com.api.rappi_u.infrastructure.persistence.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private JpaUserRepository jpaUserRepository;

    @Autowired
    private JpaOrderRepository jpaOrderRepository;


    public List<User> getAllUsers() {
        return jpaUserRepository.findAll();
    }

    public User register(User user) {
        return jpaUserRepository.save(user);
    }

    public ResponseEntity<?> logIn(String email, String password) {
        try {
            User user = jpaUserRepository.findByEmail(email).orElseThrow(() -> new Exception("Email or password are wrong"));
            if (!user.getPassword().equals(password)) {
                throw new Exception("Email or password are wrong");
            }

            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public List<Order> getUserOrders(Long id) {
        try {
            User user = jpaUserRepository.findById(id).orElseThrow(() -> new Exception("User not found"));
            return jpaOrderRepository.findByUser(user);
        } catch (Exception e) {
            return List.of();
        }


    }


}
