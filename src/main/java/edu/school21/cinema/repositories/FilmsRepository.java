package edu.school21.cinema.repositories;

import edu.school21.cinema.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmsRepository extends JpaRepository<Film, Long> {
}