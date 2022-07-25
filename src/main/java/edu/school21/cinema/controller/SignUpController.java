package edu.school21.cinema.controller;

import edu.school21.cinema.model.User;
import edu.school21.cinema.services.EmailSenderService;
import edu.school21.cinema.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/signUp")
public class SignUpController {

    private final UserService userService;

    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String doGet(HttpServletRequest request, @ModelAttribute("userDetail") User user) {
        if (request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin/panel";
        } else if (request.isUserInRole("ROLE_USER")) {
            return "redirect:/profile";
        }
        return "signUp";
    }

    @PostMapping
    public String addUser(@Valid @ModelAttribute("userDetail") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signUp";
        }
        if (!user.getPassword().equals(user.getPasswordConfirm())){
            bindingResult.rejectValue("password", "errors.password.mismatch", "errors.password.mismatch");
            return "signUp";
        }
        if (!userService.saveUser(user)){
            bindingResult.rejectValue("firstname", "errors.username.exists", "errors.username.exists");
            return "signUp";
        }
        return "redirect:/";
    }

}