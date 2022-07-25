package edu.school21.cinema.controller;

import edu.school21.cinema.enums.UserStatus;
import edu.school21.cinema.model.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
            if (request.getUserPrincipal() != null) {
                User user = (User) ((UsernamePasswordAuthenticationToken) request.getUserPrincipal()).getPrincipal();
                if (user.getStatus().equals(UserStatus.CONFIRMED)) {
                    return "redirect:/sessions";
                }
                return "redirect:/denied";
            }

        }
        return "signIn";
    }
}