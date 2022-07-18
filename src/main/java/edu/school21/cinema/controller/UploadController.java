package edu.school21.cinema.controller;

import edu.school21.cinema.model.Image;
import edu.school21.cinema.model.User;
import edu.school21.cinema.services.ImagesService;
import edu.school21.cinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Controller
@RequestMapping("/uploadAvatar")
public class UploadController {

    private final UserService userService;
    private final ImagesService imagesService;

    @Autowired
    public UploadController(UserService userService, ImagesService imagesService) {
        this.userService = userService;
        this.imagesService = imagesService;
    }

    @GetMapping()
    public String doGet() {
        return "redirect:/profile";
    }

    @PostMapping(consumes = "multipart/form-data")
    public String doPost(HttpServletRequest request, @RequestParam("file") MultipartFile file) throws IOException {
        String username = request.getUserPrincipal().getName();
        String resultFileName = imagesService.uploadFile(file);

        Image image = new Image();
        image.setFilename(resultFileName);
        image.setSize(file.getSize());
        image.setMime(file.getContentType());
        imagesService.add(image);

        User user = userService.find(username);
        user.getAvatars().add(image);
        userService.save(user);
        return "redirect:/profile";
    }
}