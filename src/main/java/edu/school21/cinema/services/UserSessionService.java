package edu.school21.cinema.services;

import edu.school21.cinema.model.User;
import edu.school21.cinema.model.UserSession;
import edu.school21.cinema.repositories.UserSessionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserSessionService {
    private final UserSessionRepository userSessionRepository;

    public UserSessionService(UserSessionRepository userSessionRepository) {
        this.userSessionRepository = userSessionRepository;
    }

    public void add(UserSession userSession)  {
        userSessionRepository.save(userSession);
    }

    public UserSession createSession(User user, String remoteAddr)  {
        UserSession userSession = new UserSession();
        userSession.setUser(user);
        userSession.setIp(remoteAddr);
        userSession.setDate(LocalDateTime.now().toLocalDate().toString());
        userSession.setTime(LocalDateTime.now().toLocalTime().toString());

        return userSession;
    }
}
