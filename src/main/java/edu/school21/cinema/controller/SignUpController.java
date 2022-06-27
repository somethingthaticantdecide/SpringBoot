package edu.school21.cinema.controller;

import edu.school21.cinema.model.User;
import edu.school21.cinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signUp")
public class SignUpController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String doGet() {
        if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated())
            return "redirect:/admin/panel";
        return "signUp";
    }

    @PostMapping
    public String addUser(User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "signUp";
        }
//        if (!userForm.getPassword().equals(user.getPasswordConfirm())){
//            model.addAttribute("passwordError", "Пароли не совпадают");
//            return "signUp";
//        }
        if (!userService.saveUser(user)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "signUp";
        }
        return "redirect:/";
    }

}