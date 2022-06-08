package edu.school21.cinema.services;

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
        return filmsRepository.getFilms();
    }

    public void add(Film film) {
        filmsRepository.add(film);
    }

    public Film getFilmById(Integer id){
        return filmsRepository.getFilmById(id);
    }

}
