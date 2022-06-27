package edu.school21.cinema.controller;

import edu.school21.cinema.services.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/films/{film-id}/chat")
public class chatController {

    private final MessagesService messagesService;

    @Autowired
    public chatController(MessagesService messagesService) {
        this.messagesService = messagesService;
    }

    @GetMapping()
    public String chat(ModelMap model, @PathVariable("film-id") String film, HttpServletRequest request) {
        model.addAttribute("messages", messagesService.getMessagesByFilmId(film));
        model.addAttribute("film", film);
        model.addAttribute("author", SecurityContextHolder.getContext().getAuthentication().getName());
        return "chat";
    }
}