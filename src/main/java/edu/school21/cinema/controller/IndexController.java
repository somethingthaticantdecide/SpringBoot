package edu.school21.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @GetMapping
    public String home() {
        return "redirect:/signIn";
    }

    @GetMapping("/denied")
    public String denied() {
        return "denied";
    }
}