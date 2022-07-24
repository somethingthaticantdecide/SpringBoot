package edu.school21.cinema.controller;

import edu.school21.cinema.model.Film;
import edu.school21.cinema.services.FilmService;
import edu.school21.cinema.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/films/{film-id}")
public class filmController {

    private final FilmService filmService;
    private final SessionService sessionService;

    @Autowired
    public filmController(FilmService filmService, SessionService sessionService) {
        this.filmService = filmService;
        this.sessionService = sessionService;
    }

    @GetMapping()
    public String chat(ModelMap model, @PathVariable("film-id") String filmId) {
        Film film = filmService.getFilmById(Long.valueOf(filmId));
        model.addAttribute("film", film);
        model.addAttribute("sessionsList", sessionService.getSessionsByFilmName(film.getTitle()));
        return "film";
    }
}