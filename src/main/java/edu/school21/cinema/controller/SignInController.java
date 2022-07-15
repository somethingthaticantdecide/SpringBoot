package edu.school21.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/signIn")
public class SignInController {

    @GetMapping
    public String doGet(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin/panel";
        } else if (request.isUserInRole("ROLE_USER")) {
            return "redirect:/sessions";
        }
        return "signIn";
    }
}