package edu.school21.cinema.controller;

import edu.school21.cinema.model.AjaxResponseBody;
import edu.school21.cinema.model.Session;
import edu.school21.cinema.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sessions")
public class SessionsController {

    private final SessionService sessionService;

    @Autowired
    public SessionsController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping()
    public String doGet() {
        return "sessionsSearch";
    }

    @GetMapping("/search")
    public ResponseEntity<?> getSearchResultViaAjax(@RequestParam("search") String search) {
        AjaxResponseBody result = new AjaxResponseBody();
        List<Session> sessions = search != null ? sessionService.getSessionsByFilmName(search) : sessionService.listSessions();
        result.setMsg(sessions.isEmpty() ? "no sessions found!" : "success");
        result.setResult(sessions);
        return ResponseEntity.ok(result);
    }
}