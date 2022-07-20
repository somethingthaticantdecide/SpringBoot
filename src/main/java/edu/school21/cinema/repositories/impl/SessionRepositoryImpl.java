//package edu.school21.cinema.repositories.impl;
//
//import edu.school21.cinema.model.Session;
//import edu.school21.cinema.repositories.SessionRepository;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//import java.util.List;
//import java.util.Locale;
//import java.util.stream.Collectors;
//
//@Repository
//@Transactional
//public class SessionRepositoryImpl implements SessionRepository {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public void add(Session session) {
//        entityManager.persist(session);
//    }
//
//    @Override
//    public List<Session> getSessions() {
//        return entityManager.createQuery(" from Session ", Session.class).getResultList();
//    }
//
//    @Override
//    public List<Session> getSessions(String filmName) {
//        return getSessions().stream().filter(cinemaSession -> cinemaSession.getFilm().getTitle().toLowerCase()
//                .contains(filmName.toLowerCase(Locale.ROOT))).collect(Collectors.toList());
//    }
//}