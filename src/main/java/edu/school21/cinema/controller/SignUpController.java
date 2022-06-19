package edu.school21.cinema.controller;

import edu.school21.cinema.enums.Role;
import edu.school21.cinema.model.User;
import edu.school21.cinema.model.UserSession;
import edu.school21.cinema.services.UserSessionService;
import edu.school21.cinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping("/signUp")
public class SignUpController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String doGet() {
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