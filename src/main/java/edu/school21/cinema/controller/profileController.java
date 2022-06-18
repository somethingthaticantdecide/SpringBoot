package edu.school21.cinema.controller;

import edu.school21.cinema.model.Image;
import edu.school21.cinema.model.User;
import edu.school21.cinema.services.ImagesService;
import edu.school21.cinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/profile")
public class profileController {

    private final UserService userService;
    private final ImagesService imagesService;
    private final String uploadPath;

    @Autowired
    public profileController(UserService userService, ImagesService imagesService, String uploadPath) {
        this.userService = userService;
        this.imagesService = imagesService;
        this.uploadPath = uploadPath;
    }

    @GetMapping
    public String doGet(ModelMap model, HttpServletRequest request) throws IOException {
        User user = userService.find((String) request.getSession().getAttribute("username"));
        model.addAttribute("user", user);
        List<Image> userAvatars = user.getAvatars();
        if (userAvatars.size() > 0) {
            model.addAttribute("avatar", userAvatars.get(userAvatars.size() - 1));
        } else {
            String resultFileName = "blankProfile.png";
            File oldFile = new ClassPathResource("/images/" + resultFileName).getFile();
            File newFile = new File(uploadPath + "/" + resultFileName);
            FileCopyUtils.copy(oldFile, newFile);
            Image image = new Image();
            image.setFilename(resultFileName);
            imagesService.add(image);

            model.addAttribute("avatar", image);
        }
        return "profile";
    }
}