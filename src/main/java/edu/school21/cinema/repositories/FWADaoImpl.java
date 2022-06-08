package edu.school21.cinema.repositories;

import edu.school21.cinema.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;

@Repository
@Transactional
public class FWADaoImpl implements FWADao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void save(String firstName, String lastName, String phone, String password) {
        entityManager.createQuery(String.format("insert into users values ( '%s', '%s', '%s', '%s' )",
                firstName, lastName, phone, password)).executeUpdate();
    }

    @Override
    public User find(String firstname) {
        return entityManager.createQuery(" FROM User WHERE firstname=:firstName", User.class)
                .setParameter("firstName", firstname).getResultList()
                .stream().findFirst().orElse(null);
    }
}