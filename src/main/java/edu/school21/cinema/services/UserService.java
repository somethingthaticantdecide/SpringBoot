package edu.school21.cinema.services;

import edu.school21.cinema.model.User;
import edu.school21.cinema.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user)  {
        userRepository.save(user);
    }

    public User find(String username)  {
        return userRepository.findByFirstname(username);
    }

    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByFirstname(username);
    }
}
