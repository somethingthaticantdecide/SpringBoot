package edu.school21.cinema.controller;

import edu.school21.cinema.model.Image;
import edu.school21.cinema.model.User;
import edu.school21.cinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private final UserService userService;

    @Autowired
    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String doGet(ModelMap model, HttpServletRequest request) throws IOException {
        User user = userService.find(request.getUserPrincipal().getName());
        model.addAttribute("user", user);
        List<Image> userAvatars = user.getAvatars();
        if (userAvatars.size() > 0) {
            model.addAttribute("avatar", userAvatars.get(userAvatars.size() - 1));
        } else {
            Image image = new Image();
            image.setFilename("blankProfile.png");
            model.addAttribute("avatar", image);
        }
        return "profile";
    }
}