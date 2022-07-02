package edu.school21.cinema.controller;

import edu.school21.cinema.model.User;
import edu.school21.cinema.services.EmailSenderService;
import edu.school21.cinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.context.SecurityContextHolder;
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
    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String doGet(HttpServletRequest request) {
        if (!SecurityContextHolder.getContext().getAuthentication().isAuthenticated())
            return "signIn";
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
//        if (!user.getPassword().equals(user.getPasswordConfirm())){
//            model.addAttribute("passwordError", "Пароли не совпадают");
//            return "signUp";
//        }
        if (!userService.saveUser(user)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "signUp";
        }

//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        mailMessage.setTo("johntom@yandex.ru");
//        mailMessage.setSubject("Complete Registration!");
//        mailMessage.setFrom("chand312902@gmail.com");
//        mailMessage.setText("To confirm your account, please click here : ");
//        emailSenderService.sendEmail(mailMessage);
        return "redirect:/";
    }

}