package edu.school21.cinema.repositories;

import edu.school21.cinema.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagesRepository extends JpaRepository<Image, Long> {
}