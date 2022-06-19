package edu.school21.cinema.repositories;

import edu.school21.cinema.model.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSessionRepository extends JpaRepository<UserSession, Long> {
}