package edu.school21.cinema.repositories;

import edu.school21.cinema.model.*;

public interface UsersRepository {

    void add(User user);

    void save(String firstName, String lastName, String phone, String password);

    User find(String username);

    void update(User user);
}