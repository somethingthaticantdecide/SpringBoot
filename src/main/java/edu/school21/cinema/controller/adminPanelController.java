package edu.school21.cinema.controller;

import edu.school21.cinema.model.Film;
import edu.school21.cinema.model.Hall;
import edu.school21.cinema.model.Session;
import edu.school21.cinema.services.FilmService;
import edu.school21.cinema.services.HallsService;
import edu.school21.cinema.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FilenameUtils;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/admin/panel")
public class adminPanelController {

    private final FilmService filmService;
    private final HallsService hallsService;
    private final SessionService sessionService;
    private final String uploadPath;

    @Autowired
    public adminPanelController(FilmService filmService, HallsService hallsService, SessionService sessionService, String uploadPath) {
        this.filmService = filmService;
        this.hallsService = hallsService;
        this.sessionService = sessionService;
        this.uploadPath = uploadPath;
    }

    @GetMapping
    public String doGet() {
        return "panel";
    }

    @GetMapping(value = "/films")
    public String films(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("filmList", filmService.listFilms());
        return "films";
    }

    @PostMapping(value = "/films/add", consumes = "multipart/form-data")
    public String addFilm(@ModelAttribute("film") Film film, @RequestParam("file") MultipartFile file) throws IOException {
        if (null != film && !film.getTitle().isEmpty()) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            if (file.getSize() > 0) {
                String uuidFile = UUID.nameUUIDFromBytes(file.getBytes()).toString();
                String resultFileName = uuidFile + "." + FilenameUtils.getExtension(file.getOriginalFilename());
                file.transferTo(new File(uploadPath + "/" + resultFileName));
                film.setPoster(resultFileName);
            } else {
                film.setPoster("/images/poster-holder.jpg");
            }
            filmService.add(film);
        }
        return "redirect:/admin/panel/films";
    }

    @GetMapping(value = "/halls")
    public String halls(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("hallList", hallsService.listHalls());
        return "halls";
    }

    @PostMapping(value = "/halls/add")
    public String addHall(@ModelAttribute("hall") Hall hall) {
        if (null != hall && 0 != hall.getSeats() && !hall.getName().isEmpty()) {
            hallsService.add(hall);
        }
        return "redirect:/admin/panel/halls";
    }

    @GetMapping(value = "/sessions")
    public String init(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("sessionsList", sessionService.listSessions());
        model.addAttribute("hallList", hallsService.listHalls());
        model.addAttribute("filmList", filmService.listFilms());
        return "sessions";
    }

    @PostMapping(value = "/sessions/add")
    public String addSession(Session session, @ModelAttribute("film_id") String film_id, @ModelAttribute("hall_id") String hall_id) {
        if (session != null) {
            Film film = filmService.getFilmById(Integer.valueOf(film_id));
            Hall hall = hallsService.getHallById(Integer.valueOf(hall_id));

            if (hall != null && film != null && !session.getTime().isEmpty()) {
                session.setHall(hall);
                session.setFilm(film);
                sessionService.add(session);
            }
        }
        return "redirect:/admin/panel/sessions";
    }

}