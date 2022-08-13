package edu.school21.cinema.services;

import edu.school21.cinema.model.Session;
import edu.school21.cinema.repositories.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

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

    public List<Session> getSessionsByFilmName(String filmName) {
        return listSessions().stream().filter(cinemaSession -> cinemaSession.getFilm().getTitle().toLowerCase()
                .contains(filmName.toLowerCase(Locale.ROOT))).collect(Collectors.toList());
    }

}
