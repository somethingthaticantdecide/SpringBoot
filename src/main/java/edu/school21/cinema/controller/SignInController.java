package edu.school21.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
        if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated())
            return "redirect:/admin/panel";
        return "signIn";
    }

    @PostMapping
    public String doPost(HttpServletRequest request) {
        return "signIn";
    }

}