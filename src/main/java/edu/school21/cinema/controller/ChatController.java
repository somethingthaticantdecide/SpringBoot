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
public class ChatController {

    private final MessagesService messagesService;
    private final FilmService filmService;

    @Autowired
    public ChatController(MessagesService messagesService, FilmService filmService) {
        this.messagesService = messagesService;
        this.filmService = filmService;
    }

    @GetMapping()
    public String chat(ModelMap model, @PathVariable("film-id") String film_id) {
        model.addAttribute("messages", messagesService.getMessagesByFilmId(film_id));
        model.addAttribute("film", filmService.getFilmById(Long.valueOf(film_id)).getId());
        model.addAttribute("author", SecurityContextHolder.getContext().getAuthentication().getName());
        return "chat";
    }
}