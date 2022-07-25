package edu.school21.cinema.controller;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class indexController {

    @GetMapping
    public String home() {
        return "redirect:/signIn";
    }

    @GetMapping("/denied")
    public String denied(HttpServletRequest request) {
        ((UsernamePasswordAuthenticationToken) request.getUserPrincipal()).setAuthenticated(false);
        return "denied";
    }
}