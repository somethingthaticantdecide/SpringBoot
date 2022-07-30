package edu.school21.cinema.services;

import edu.school21.cinema.model.Image;
import edu.school21.cinema.repositories.ImagesRepository;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class ImagesService {
    private final ImagesRepository imagesRepository;
    private final String uploadPath;

    public ImagesService(ImagesRepository imagesRepository, String uploadPath) {
        this.imagesRepository = imagesRepository;
        this.uploadPath = uploadPath;
    }

    public void add(Image image) {
        imagesRepository.save(image);
    }

    public String uploadFile(MultipartFile file) throws IOException {
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        String uuidFile = UUID.nameUUIDFromBytes(file.getBytes()).toString();
        String resultFileName = uuidFile + "." + FilenameUtils.getExtension(file.getOriginalFilename());
        file.transferTo(new File(uploadPath + "/" + resultFileName));

        return resultFileName;
    }
}
