package edu.school21.cinema.controller;

import edu.school21.cinema.services.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/signIn")
public class SignInController {

    @GetMapping
    public String doGet(HttpServletRequest request) {
        if (!SecurityContextHolder.getContext().getAuthentication().isAuthenticated())
            return "signIn";
        if (request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin/panel";
        } else if (request.isUserInRole("ROLE_USER")) {
            return "redirect:/profile";
        }

        return "signIn";
    }

    @PostMapping
    public String doPost() {
        return "signIn";
    }

}