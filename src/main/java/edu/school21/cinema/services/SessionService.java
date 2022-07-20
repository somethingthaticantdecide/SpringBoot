package edu.school21.cinema.services;

import edu.school21.cinema.model.Session;
import edu.school21.cinema.repositories.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {
    private final SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public List<Session> listSessions() {
        return sessionRepository.findAll();
    }

    public void add(Session session) {
        sessionRepository.save(session);
    }

    public List<Session> listSessions(String filmName) {
        return sessionRepository.getSessions(filmName);
    }

}
