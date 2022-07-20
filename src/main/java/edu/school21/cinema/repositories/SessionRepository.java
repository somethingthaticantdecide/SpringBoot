package edu.school21.cinema.repositories;

import edu.school21.cinema.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {

}