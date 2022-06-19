package edu.school21.cinema.repositories.impl;

import edu.school21.cinema.model.Film;
import edu.school21.cinema.repositories.FilmsRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class FilmsRepositoryImpl implements FilmsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Film film) {
        entityManager.persist(film);
    }

    @Override
    public List<Film> getFilms() {
        return entityManager.createQuery(" from Film ", Film.class).getResultList();
    }

    @Override
    public Film getFilmById(Integer id) {
        return entityManager.find(Film.class, id);
    }

}