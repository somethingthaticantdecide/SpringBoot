package edu.school21.cinema.controller;

import edu.school21.cinema.services.FilmService;
import edu.school21.cinema.services.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/films/{film-id}/chat")
public class chatController {

    private final MessagesService messagesService;
    private final FilmService filmService;

    @Autowired
    public chatController(MessagesService messagesService, FilmService filmService) {
        this.messagesService = messagesService;
        this.filmService = filmService;
    }

    @GetMapping()
    public String chat(ModelMap model, @PathVariable("film-id") String film) {
        model.addAttribute("messages", messagesService.getMessagesByFilmId(film));
        model.addAttribute("film", filmService.getFilmById(Long.valueOf(film)));
        model.addAttribute("author", SecurityContextHolder.getContext().getAuthentication().getName());
        return "chat";
    }
}