package edu.school21.cinema.repositories;

import edu.school21.cinema.model.Hall;

import java.util.List;

public interface HallsRepository {

    void add(Hall hall);

    List<Hall> getHalls();

    Hall getHallById(Integer id);

}