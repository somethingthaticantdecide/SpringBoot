package edu.school21.cinema.repositories;

import edu.school21.cinema.model.Session;
import edu.school21.cinema.model.User;
import edu.school21.cinema.model.UserSession;

import java.util.List;

public interface UserSessionRepository {

    void add(UserSession session);

    List<UserSession> getSessions();

    List<UserSession> getSessionsByUser(User user);

    Session getSessionById(Integer id);
}