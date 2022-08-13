package edu.school21.cinema.repositories;

import edu.school21.cinema.model.Hall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallsRepository extends JpaRepository<Hall, Long> {
}