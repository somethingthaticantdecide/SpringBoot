package edu.school21.cinema.repositories.impl;

import edu.school21.cinema.model.OutputMessage;
import edu.school21.cinema.repositories.MessagesRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MessagesRepositoryImpl implements MessagesRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(OutputMessage outputMessage) {
        entityManager.persist(outputMessage);
    }

    @Override
    public List<OutputMessage> getMessagesByFilmId(String film) {
        TypedQuery<OutputMessage> typedQuery = entityManager.createQuery(" FROM OutputMessage m WHERE m.film=:film", OutputMessage.class);
        typedQuery.setParameter("film", film);
        return typedQuery.getResultList();
    }
}