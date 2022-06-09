package edu.school21.cinema.services;

import edu.school21.cinema.model.User;
import edu.school21.cinema.repositories.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void add(User user)  {
        usersRepository.add(user);
    }

    public User find(String username)  {
        return usersRepository.find(username);
    }

    public boolean authorize(String username, String password) {
        User user = usersRepository.find(username);
        return user != null && Objects.equals(user.getPassword(), password);
    }
}
