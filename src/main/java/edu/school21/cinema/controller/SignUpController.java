package edu.school21.cinema.controller;

import edu.school21.cinema.model.User;
import edu.school21.cinema.services.EmailSenderService;
import edu.school21.cinema.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/signUp")
public class SignUpController {

    private final UserService userService;
    private final EmailSenderService emailSenderService;

    public SignUpController(UserService userService, EmailSenderService emailSenderService) {
        this.userService = userService;
        this.emailSenderService = emailSenderService;
    }

    @GetMapping
    public String doGet(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin/panel";
        } else if (request.isUserInRole("ROLE_USER")) {
            return "redirect:/profile";
        }
        return "signUp";
    }

    @PostMapping
    public String addUser(User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "signUp";
        }
        if (!user.getPassword().equals(user.getPasswordConfirm())){
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "signUp";
        }
        if (!userService.saveUser(user)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "signUp";
        }
        return "redirect:/";
    }

}