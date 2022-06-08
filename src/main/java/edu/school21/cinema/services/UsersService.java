package edu.school21.cinema.services;

import edu.school21.cinema.model.User;
import edu.school21.cinema.repositories.FWADao;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UsersService {
    private final FWADao fwaDao;

    public UsersService(FWADao fwaDao) {
        this.fwaDao = fwaDao;
    }

    public void signUp(String first_name, String last_name, String phone, String password)  {
        User user = new User(first_name, last_name, phone, password);
        fwaDao.add(user);
    }

    public User find(String username)  {
        return fwaDao.find(username);
    }

    public boolean authorize(String username, String password) {
        User user = fwaDao.find(username);
        return user != null && Objects.equals(user.getPassword(), password);
    }
}
