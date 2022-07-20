package edu.school21.cinema.repositories;

import edu.school21.cinema.model.OutputMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessagesRepository extends JpaRepository<OutputMessage, Long> {
    List<OutputMessage> findAllByFilm(String film);
}