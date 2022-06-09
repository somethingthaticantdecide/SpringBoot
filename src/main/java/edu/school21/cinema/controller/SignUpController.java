package edu.school21.cinema.controller;

import edu.school21.cinema.model.User;
import edu.school21.cinema.model.UserSession;
import edu.school21.cinema.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping("/signUp")
public class SignUpController {

    private final UsersService usersService;

    @Autowired
    public SignUpController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public String doGet() {
        return "signUp";
    }

    @PostMapping
    public String doPost(HttpServletRequest req) {
        String firstName = req.getParameter("firstName");
        if (usersService.find(firstName) != null)
            return "signUp";
        User user = new User();
        user.setFirstname(firstName);
        user.setLastName(req.getParameter("lastName"));
        user.setPhoneNumber(req.getParameter("phoneNumber"));
        user.setPassword(req.getParameter("password"));
        user.setAvatars(new ArrayList<>());
        user.setSessions(new ArrayList<>());
        user.getSessions().add(new UserSession(user, ZonedDateTime.now().toLocalDate().toString(), ZonedDateTime.now().toLocalTime().toString(), req.getRemoteAddr()));
        usersService.add(user);
        return "redirect:/sessions";
    }

}