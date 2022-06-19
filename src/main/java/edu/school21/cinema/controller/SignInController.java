package edu.school21.cinema.controller;

import edu.school21.cinema.model.User;
import edu.school21.cinema.model.UserSession;
import edu.school21.cinema.services.UserSessionService;
import edu.school21.cinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/signIn")
public class SignInController {

    @Autowired
    public SignInController() {
    }

    @GetMapping
    public String doGet() {
        return "signIn";
    }

    @PostMapping
    public String doPost(HttpServletRequest request) {
        return "signIn";
    }

}