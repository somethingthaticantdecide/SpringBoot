package edu.school21.cinema.controller;

import edu.school21.cinema.enums.UserStatus;
import edu.school21.cinema.model.User;
import edu.school21.cinema.services.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/signIn")
public class SignInController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public SignInController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String doGet(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin/panel";
        } else if (request.isUserInRole("ROLE_USER")) {
            User user = userService.find(request.getUserPrincipal().getName());
            return user.getStatus().equals(UserStatus.CONFIRMED) ? "redirect:/sessions" : "redirect:/denied";
        }
        return "signIn";
    }

    @PostMapping
    public String addUser(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userService.find(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            if (!user.getStatus().equals(UserStatus.CONFIRMED)) {
                return "redirect:/denied";
            }
            Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            userService.addUserSession(request.getRemoteAddr(), user);
            return "redirect:/sessions";
        }
        return "signIn";
    }
}