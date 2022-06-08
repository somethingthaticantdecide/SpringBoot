package edu.school21.cinema.services;

import edu.school21.cinema.model.Image;
import edu.school21.cinema.model.OutputMessage;
import edu.school21.cinema.repositories.ImagesRepository;
import edu.school21.cinema.repositories.MessagesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImagesService {
    private final ImagesRepository imagesRepository;

    public ImagesService(ImagesRepository imagesRepository) {
        this.imagesRepository = imagesRepository;
    }

    public List<Image> listImages() {
        return imagesRepository.getImages();
    }

    public void add(Image image) {
        imagesRepository.add(image);
    }

    public Image getImageById(Integer id){
        return imagesRepository.getImageById(id);
    }

    public Image getImageByName(String name){
        return imagesRepository.getImageByName(name);
    }
}
