package edu.school21.cinema.controller;

import edu.school21.cinema.enums.Role;
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
import java.util.ArrayList;

@Controller
@RequestMapping("/signUp")
public class SignUpController {

    private final UserService userService;
    private final UserSessionService userSessionService;

    @Autowired
    public SignUpController(UserService userService, UserSessionService userSessionService) {
        this.userService = userService;
        this.userSessionService = userSessionService;
    }

    @GetMapping
    public String doGet() {
        return "signUp";
    }

    @PostMapping
    public String doPost(HttpServletRequest req) {
        String firstName = req.getParameter("firstName");
        if (userService.find(firstName) != null)
            return "signUp";

        User user = new User();
        user.setFirstname(firstName);
        user.setLastName(req.getParameter("lastName"));
        user.setPhoneNumber(req.getParameter("phoneNumber"));
        user.setPassword(req.getParameter("password"));
        user.setAvatars(new ArrayList<>());
        user.setSessions(new ArrayList<>());
        user.setRoles(firstName.equals("admin") ? Role.ROLE_ADMIN : Role.ROLE_USER);
        userService.save(user);

        UserSession userSession = userSessionService.createSession(user, req.getRemoteAddr());
        userSessionService.add(userSession);

        user.getSessions().add(userSession);
        userService.save(user);

        return firstName.equals("admin") ? "redirect:/admin/panel" : "redirect:/sessions";
    }

}