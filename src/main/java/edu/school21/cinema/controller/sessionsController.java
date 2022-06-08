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

    @PostMapping("/search")
    public ResponseEntity<?> getSearchResultViaAjax(@Valid @RequestBody SearchCriteria search, Errors errors) {
        AjaxResponseBody result = new AjaxResponseBody();
        if (errors.hasErrors()) {
            result.setMsg(errors.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);
        }
        List<Session> sessions = search.getUsername() != null ? sessionService.listSessions(search.getUsername()) : sessionService.listSessions();
        result.setMsg(sessions.isEmpty() ? "no sessions found!" : "success");
        result.setResult(sessions);

        return ResponseEntity.ok(result);
    }
}