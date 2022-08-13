package edu.school21.cinema.repositories;

import edu.school21.cinema.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByFirstname(String username);
}