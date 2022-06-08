package edu.school21.cinema.repositories;

import edu.school21.cinema.model.Image;

import java.util.List;

public interface ImagesRepository {

    void add(Image image);

    List<Image> getImages();

    Image getImageById(Integer id);

    Image getImageByName(String name);
}