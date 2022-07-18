package edu.school21.cinema.controller;

import edu.school21.cinema.model.AjaxResponseBody;
import edu.school21.cinema.model.SearchCriteria;
import edu.school21.cinema.model.Session;
import edu.school21.cinema.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/sessions")
public class sessionsController {

    private final SessionService sessionService;

    @Autowired
    public sessionsController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping()
    public String doGet() {
        return "sessionsSearch";
    }

    @GetMapping("/search")
    public ResponseEntity<?> getSearchResultViaAjax(@RequestParam("username") String username) {
        AjaxResponseBody result = new AjaxResponseBody();

        List<Session> sessions = username != null ? sessionService.listSessions(username) : sessionService.listSessions();
        result.setMsg(sessions.isEmpty() ? "no sessions found!" : "success");
        result.setResult(sessions);

        return ResponseEntity.ok(result);
    }
}