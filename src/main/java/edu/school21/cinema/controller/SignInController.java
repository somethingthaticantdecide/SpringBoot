package edu.school21.cinema.controller;

import edu.school21.cinema.enums.UserStatus;
import edu.school21.cinema.model.User;
import edu.school21.cinema.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/signIn")
public class SignInController {

    private final UserService userService;

    public SignInController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String doGet(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin/panel";
        } else if (!request.isUserInRole("ROLE_USER")) {
            return "signIn";
        }
        User user = userService.find(request.getUserPrincipal().getName());
        if (user.getStatus().equals(UserStatus.CONFIRMED)) {
            userService.addUserSession(request.getRemoteAddr(), user);
            return "redirect:/sessions";
        }
        return "redirect:/denied";
    }
}