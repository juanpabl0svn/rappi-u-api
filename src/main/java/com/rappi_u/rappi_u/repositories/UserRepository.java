package com.rappi_u.rappi_u.repositories;
import com.rappi_u.rappi_u.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
