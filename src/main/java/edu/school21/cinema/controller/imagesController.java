package edu.school21.cinema.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/images")
public class imagesController {

    private final String uploadPath;

    @Autowired
    public imagesController(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    @GetMapping(value = "/{name}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getContent(@PathVariable("name") String name) {
        try {
            byte[] bytes = FileUtils.readFileToByteArray(new File(uploadPath + "/" + name));
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
        } catch (IOException e) {
            return ResponseEntity.notFound().build();
        }
    }
}