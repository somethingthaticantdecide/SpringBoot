package edu.school21.cinema.repositories;

import edu.school21.cinema.model.Film;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
    public Film getByTitle(String filmName) {
        TypedQuery<Film> typedQuery = entityManager.createQuery(" FROM Film f WHERE f.title=:title", Film.class);
        typedQuery.setParameter("title", filmName);
        return typedQuery.getSingleResult();
    }

    @Override
    public Film getFilmById(Integer id) {
        return entityManager.find(Film.class, id);
    }

}