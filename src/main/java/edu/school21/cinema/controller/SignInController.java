package edu.school21.cinema.controller;

import edu.school21.cinema.model.User;
import edu.school21.cinema.model.UserSession;
import edu.school21.cinema.services.UserSessionService;
import edu.school21.cinema.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Objects;

@Controller
@RequestMapping("/signIn")
public class SignInController {

    private final UsersService usersService;
    private final UserSessionService userSessionService;

    @Autowired
    public SignInController(UsersService usersService, UserSessionService userSessionService) {
        this.usersService = usersService;
        this.userSessionService = userSessionService;
    }

    @GetMapping
    public String doGet() {
        return "signIn";
    }

    @PostMapping
    public String doPost(HttpServletRequest request) {
        String username = request.getParameter("username");
        User user = usersService.find(username);
        if (user != null && Objects.equals(user.getPassword(), request.getParameter("password"))) {
            request.getSession().setAttribute("username", username);
            UserSession userSession = new UserSession();
            userSession.setUser(user);
            userSession.setIp(request.getRemoteAddr());
            userSession.setDate(LocalDateTime.now().toLocalDate().toString());
            userSession.setTime(LocalDateTime.now().toLocalTime().toString());
            userSessionService.add(userSession);
            return username.equals("admin") ? "redirect:/admin/panel" : "redirect:/sessions";
        }
        return "signIn";
    }

}