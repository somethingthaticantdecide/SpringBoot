package edu.school21.cinema.controller;

import edu.school21.cinema.model.UserSession;
import edu.school21.cinema.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;

@Controller
@RequestMapping("/signIn")
public class SignInController {

    private final UsersService usersService;

    @Autowired
    public SignInController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public String doGet() {
        return "signIn";
    }

    @PostMapping
    public String doPost(HttpServletRequest request) {
        String username = request.getParameter("username");
        if (usersService.authorize(username, request.getParameter("password"))) {
            request.getSession().setAttribute("username", username);
            return username.equals("admin") ? "redirect:/admin/panel" : "redirect:/sessions";
        }
        return "signIn";
    }

}