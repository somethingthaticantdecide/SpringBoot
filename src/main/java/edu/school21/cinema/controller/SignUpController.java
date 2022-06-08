package edu.school21.cinema.controller;

import edu.school21.cinema.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

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
        usersService.signUp(firstName, req.getParameter("lastName"), req.getParameter("phoneNumber"), req.getParameter("password"));
        req.getSession().setAttribute("username", firstName);
        return "redirect:/sessions";
    }

}