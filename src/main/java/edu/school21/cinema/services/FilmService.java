package edu.school21.cinema.services;

import edu.school21.cinema.exceptions.ResourceNotFoundException;
import edu.school21.cinema.model.Film;
import edu.school21.cinema.repositories.FilmsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {
    private final FilmsRepository filmsRepository;

    public FilmService(FilmsRepository filmsRepository) {
        this.filmsRepository = filmsRepository;
    }

    public List<Film> listFilms() {
        return filmsRepository.findAll();
    }

    public void add(Film film) {
        filmsRepository.save(film);
    }

    public Film getFilmById(Long id){
        return filmsRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Product with id " + id + " not found"));
    }

}
