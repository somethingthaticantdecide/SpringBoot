package edu.school21.cinema.repositories;

import edu.school21.cinema.model.Film;

import java.util.List;

public interface FilmsRepository {

    void add(Film film);

    List<Film> getFilms();

    Film getFilmById(Integer getFilmById);
}