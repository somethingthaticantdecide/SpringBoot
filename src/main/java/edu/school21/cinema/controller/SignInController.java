package edu.school21.cinema.controller;

import edu.school21.cinema.model.User;
import edu.school21.cinema.model.UserSession;
import edu.school21.cinema.services.UserSessionService;
import edu.school21.cinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
@RequestMapping("/signIn")
public class SignInController {

    private final UserService userService;
    private final UserSessionService userSessionService;

    @Autowired
    public SignInController(UserService userService, UserSessionService userSessionService) {
        this.userService = userService;
        this.userSessionService = userSessionService;
    }

    @GetMapping
    public String doGet() {
        return "signIn";
    }

    @PostMapping
    public String doPost(HttpServletRequest request) {
        String username = request.getParameter("username");
        User user = userService.find(username);
        if (user != null && Objects.equals(user.getPassword(), request.getParameter("password"))) {
            request.getSession().setAttribute("username", username);

            UserSession userSession = userSessionService.createSession(user, request.getRemoteAddr());
            userSessionService.add(userSession);

            user.getSessions().add(userSession);
            userService.save(user);
            return username.equals("admin") ? "redirect:/admin/panel" : "redirect:/sessions";
        }
        return "signIn";
    }

}