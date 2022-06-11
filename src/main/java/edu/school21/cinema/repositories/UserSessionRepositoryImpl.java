package edu.school21.cinema.repositories;

import edu.school21.cinema.model.Session;
import edu.school21.cinema.model.User;
import edu.school21.cinema.model.UserSession;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserSessionRepositoryImpl implements UserSessionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(UserSession userSession) {
        entityManager.persist(userSession);
    }

    @Override
    public List<UserSession> getSessions() {
        return entityManager.createQuery(" from UserSession ", UserSession.class).getResultList();
    }

    @Override
    public List<UserSession> getSessionsByUser(User user) {
        return null;
    }

    @Override
    public Session getSessionById(Integer id) {
        return entityManager.find(Session.class, id);
    }

    public List<Session> getSessions(String filmName) {
        return null;
    }
}