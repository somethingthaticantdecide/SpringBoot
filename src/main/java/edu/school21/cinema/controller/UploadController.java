package edu.school21.cinema.controller;

import edu.school21.cinema.model.Image;
import edu.school21.cinema.model.User;
import edu.school21.cinema.services.ImagesService;
import edu.school21.cinema.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Controller
@RequestMapping("/uploadAvatar")
public class UploadController {

    private final UsersService usersService;
    private final ImagesService imagesService;

    @Autowired
    public UploadController(UsersService usersService, ImagesService imagesService) {
        this.usersService = usersService;
        this.imagesService = imagesService;
    }

    @GetMapping()
    public String doGet() {
        return "redirect:/profile";
    }

    @PostMapping(consumes = "multipart/form-data")
    public String doPost(HttpServletRequest request, @RequestParam("file") MultipartFile file) throws IOException {
        String username = (String) request.getSession().getAttribute("username");
        String resultFileName = imagesService.uploadFile(file);

        Image image = new Image();
        image.setFilename(resultFileName);
        image.setSize(file.getSize());
        image.setMime(file.getContentType());
        imagesService.add(image);

        User user = usersService.find(username);
        user.getAvatars().add(image);
        user.setLastName("qwe");
        usersService.update(user);
        return "redirect:/profile";
    }
}