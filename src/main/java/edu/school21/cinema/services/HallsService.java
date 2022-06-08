package edu.school21.cinema.services;

import edu.school21.cinema.model.Hall;
import edu.school21.cinema.repositories.HallsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallsService {
    private final HallsRepository hallsRepository;

    public HallsService(HallsRepository hallsRepository) {
        this.hallsRepository = hallsRepository;
    }

    public List<Hall> listHalls() {
        return hallsRepository.getHalls();
    }

    public void add(Hall hall) {
        hallsRepository.add(hall);
    }

    public Hall getHallById(Integer id){
        return hallsRepository.getHallById(id);
    }
}
