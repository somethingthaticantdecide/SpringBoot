package edu.school21.cinema.repositories;

import edu.school21.cinema.model.Hall;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class HallsRepositoryImpl implements HallsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Hall hall) {
        entityManager.persist(hall);
    }

    @Override
    public List<Hall> getHalls() {
        return entityManager.createQuery(" from Hall ", Hall.class).getResultList();
    }

    @Override
    public Hall getHallById(Integer id) {
        return entityManager.find(Hall.class, id);
    }
}