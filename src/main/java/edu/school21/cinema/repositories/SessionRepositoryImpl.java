package edu.school21.cinema.repositories;

import edu.school21.cinema.model.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Repository
@Transactional
public class SessionRepositoryImpl implements SessionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Session session) {
        entityManager.persist(session);
    }

    @Override
    public List<Session> getSessions() {
        return entityManager.createQuery(" from Session ", Session.class).getResultList();
    }


    @Override
    public Session getSessionById(Integer id) {
        return entityManager.find(Session.class, id);
    }

    @Override
    public List<Session> getSessions(String filmName) {
//        entityManager.createQuery("from Session WHERE film=:film", Session.class)
//                .setParameter("film", getByTitle(filmName)).getResultList();
//        entityManager.createNativeQuery("select * from sessions WHERE film in (select id from films WHERE title = ?)", Session.class)
//                .setParameter(1, filmName).getResultList();
        return getSessions().stream().filter(cinemaSession -> cinemaSession.getFilm().getTitle().toLowerCase().contains(filmName.toLowerCase(Locale.ROOT))).collect(Collectors.toList());
    }
}