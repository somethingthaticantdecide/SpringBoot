package edu.school21.cinema.repositories;

import edu.school21.cinema.model.Session;

import javax.transaction.Transactional;
import java.util.List;

public interface SessionRepository {

    void add(Session session);

    List<Session> getSessions();

    List<Session> getSessions(String filmName);

    Session getSessionById(Integer id);
}