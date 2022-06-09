package edu.school21.cinema.controller;

import edu.school21.cinema.model.Image;
import edu.school21.cinema.services.ImagesService;
import org.apache.commons.io.FileUtils;
import org.hibernate.engine.jdbc.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/images")
public class imagesController {

    private final ImagesService imagesService;
    private final String uploadPath;

    @Autowired
    public imagesController(ImagesService imagesService, String uploadPath) {
        this.imagesService = imagesService;
        this.uploadPath = uploadPath;
    }

    @GetMapping(value = "/{name}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getContent(@PathVariable("name") String name) {
        try {
            Image image = imagesService.getImageByName(name);
            byte[] bytes = FileUtils.readFileToByteArray(new File(uploadPath + "/" + image.getFilename()));
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
        } catch (IOException e) {
            return ResponseEntity.notFound().build();
        }
    }
}